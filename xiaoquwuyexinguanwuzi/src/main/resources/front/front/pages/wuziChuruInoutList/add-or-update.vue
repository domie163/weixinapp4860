<template>
    <view class="content">
        <form class="app-update-pv">
                <!--<view :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                      class="cu-form-group">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                          class="title">出入库</view>
                    <picker @change="wuziChuruInoutChange" :value="wuziChuruInoutIndex" :range="wuziChuruInoutOptions" range-key="wuziChuruInoutName">
                        <view
                                :style='{"padding":"0 30rpx","boxShadow":"0 0 16rpx var(--publicSubColor) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"20rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                                class="uni-input">{{ruleForm.wuziChuruInoutId?ruleForm.wuziChuruInoutName:"请选择出入库"}}</view>
                    </picker>
                </view>-->
                <!--<view :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                      class="cu-form-group">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                          class="title">物资</view>
                    <picker @change="wuziChange" :value="wuziIndex" :range="wuziOptions" range-key="wuziName">
                        <view
                                :style='{"padding":"0 30rpx","boxShadow":"0 0 16rpx var(--publicSubColor) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"20rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                                class="uni-input">{{ruleForm.wuziId?ruleForm.wuziName:"请选择物资"}}</view>
                    </picker>
                </view>-->
                <view
                        :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                        class="cu-form-group">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                          class="title">操作数量</view>
                    <input   disabled
                             :style='{"padding":"0 24rpx","boxShadow":"0px 6rpx 12rpx var(--publicSubColor)","margin":"6rpx 0rpx","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","color":"#333","textAlign":"left","borderRadius":"40rpx 0","borderWidth":"0","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                             :disabled="ro.wuziChuruInoutListNumber" type="number" v-model="ruleForm.wuziChuruInoutListNumber" placeholder="操作数量"></input>
                </view>

            <view class="btn">
                <button
                        :style='{"boxShadow":"0 0 16rpx rgba(0,0,0,0) inset","backgroundColor":"var(--publicMainColor)","borderColor":"#409EFF","borderRadius":"8rpx","color":"rgba(255, 255, 255, 1)","borderWidth":"0","width":"70%","fontSize":"32rpx","borderStyle":"solid","height":"80rpx"}'
                        @tap="onSubmitTap" class="bg-red">提交</button>
            </view>
        </form>

					<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="insertTimeConfirm"
                              ref="insertTime" themeColor="#333333"></w-picker>
					<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="createTimeConfirm"
                              ref="createTime" themeColor="#333333"></w-picker>


    </view>
</template>

<script>
    import wPicker from "@/components/w-picker/w-picker.vue";

    export default {
        data() {
            return {
                cross: '',
                ro:{
					wuziChuruInoutId: false,
					wuziId: false,
					wuziChuruInoutListNumber: false,
					insertTime: false,
					createTime: false,
        },
            ruleForm: {
					wuziChuruInoutId: '',
					wuziId: '',
					wuziChuruInoutListNumber: '',
					insertTime: '',
					createTime: '',
            },
            // 登陆用户信息
            user: {},
            wuziChuruInoutOptions: [],//出入库
            wuziChuruInoutIndex : 0,//出入库下标
            wuziOptions: [],//物资
            wuziIndex : 0,//物资下标

        }
        },
        components: {
            wPicker
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            },
        },
        async onLoad(options) {
            let wuziChuruInoutParams = {
                page: 1,
                limit: 100,
            }
            let wuziChuruInoutData = await this.$api.page(`wuziChuruInout`, wuziChuruInoutParams);
            this.wuziChuruInoutOptions = wuziChuruInoutData.data.list;
            let wuziParams = {
                page: 1,
                limit: 100,
            }
            let wuziData = await this.$api.page(`wuzi`, wuziParams);
            this.wuziOptions = wuziData.data.list;


            // 如果是更新操作
            if (options.id) {
                this.ruleForm.id = options.id;
                // 获取信息
                let res = await this.$api.info(`wuziChuruInoutList`, this.ruleForm.id);
                this.ruleForm = res.data;
            }
            if(options.wuziChuruInoutListId){
                this.ruleForm.wuziChuruInoutListId = options.wuziChuruInoutListId;
            }
            // 跨表
            // this.styleChange()
        },
        methods: {
            wuziChuruInoutChange(e) {
                this.wuziChuruInoutIndex = e.target.value
                this.ruleForm.wuziChuruInoutName = this.wuziChuruInoutOptions[this.wuziChuruInoutIndex].wuziChuruInoutName
                this.ruleForm.wuziChuruInoutId = this.wuziChuruInoutOptions[this.wuziChuruInoutIndex].id
            },
            wuziChange(e) {
                this.wuziIndex = e.target.value
                this.ruleForm.wuziName = this.wuziOptions[this.wuziIndex].wuziName
                this.ruleForm.wuziId = this.wuziOptions[this.wuziIndex].id
            },
            // 下拉变化
            // styleChange() {
            // 	this.$nextTick(() => {
            // 		// document.querySelectorAll('.app-update-pv .cu-form-group .uni-yaoxianStyle-yaoxianStyle').forEach(el=>{
            // 		//   el.style.backgroundColor = this.addUpdateForm.yaoxianStyle.content.backgroundColor
            // 		// })
            // 	})
            // },
			// 日期控件
			insertTimeConfirm(val) {
                this.ruleForm.insertTime = val.result;
                this.$forceUpdate();
            },
			// 日期控件
			createTimeConfirm(val) {
                this.ruleForm.createTime = val.result;
                this.$forceUpdate();
            },

            getUUID() {
                return new Date().getTime();
            },
            async onSubmitTap() {
				if ((!this.ruleForm.wuziChuruInoutListNumber) && (!this.$validate.isIntNumer(this.ruleForm.wuziChuruInoutListNumber)) && this.ruleForm.wuziChuruInoutListNumber >0) {
                    this.$utils.msg(`操作数量不能为空，不能小于0 格式为数字`);
                    return
                }
                if (this.ruleForm.id) {
                    await this.$api.update(`wuziChuruInoutList`, this.ruleForm);
                } else {
                    await this.$api.save(`wuziChuruInoutList`, this.ruleForm);
                }
                uni.setStorageSync('pingluenStateState', true);
                this.$utils.msgBack('提交成功');
            },
            getDate(type) {
                const date = new Date();
                let year = date.getFullYear();
                let month = date.getMonth() + 1;
                let day = date.getDate();
                if (type === 'start') {
                    year = year - 60;
                } else if (type === 'end') {
                    year = year + 2;
                }
                month = month > 9 ? month : '0' + month;;
                day = day > 9 ? day : '0' + day;
                return `${year}-${month}-${day}`;
            },
            toggleTab(str) {
                this.$refs[str].show();
            }
        }
    }
</script>
<style lang="scss" scoped>
    .container {
        padding: 20upx;
    }

    .content:after {
        position: fixed;
        top: 0;
        right: 0;
        left: 0;
        bottom: 0;
        content: '';
        background-attachment: fixed;
        background-size: cover;
        background-position: center;
    }

    textarea {
        border: 1upx solid #EEEEEE;
        border-radius: 20upx;
        padding: 20upx;
    }

    .title {
        width: 180upx;
    }

    .avator {
        width: 150upx;
        height: 60upx;
    }

    .right-input {
        flex: 1;
        text-align: left;
        padding: 0 24upx;
    }

    .cu-form-group.active {
        justify-content: space-between;
    }

    .cu-form-group .title {
        height: auto;
        line-height:30rpx
    }

    .btn {
        display: flex;
        align-items: center;
        justify-content: center;
        flex-wrap: wrap;
        padding: 20upx 0;
    }

    .cu-form-group {
        padding: 0 24upx;
        background-color: transparent;
        min-height: inherit;
    }

    .cu-form-group+.cu-form-group {
        border: 0;
    }

    .cu-form-group uni-input {
        padding: 0 30upx;
    }

    .uni-input {
        padding: 0 30upx;
    }

    .cu-form-group uni-textarea {
        padding: 30upx;
        margin: 0;
    }

    .cu-form-group uni-picker::after {
        line-height: 80rpx;
    }

    .select .uni-input {
        line-height: 80rpx;
    }

    .input .right-input {
        line-height: 88rpx;
    }
</style>