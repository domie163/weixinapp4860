<template>
    <view class="content">
        <form class="app-update-pv">
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">物资编号</view>
                <input   disabled
                         :style='{"padding":"0 24rpx","boxShadow":"0px 6rpx 12rpx var(--publicSubColor)","margin":"6rpx 0rpx","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","color":"#333","textAlign":"left","borderRadius":"40rpx 0","borderWidth":"0","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                         :disabled="ro.wuziUuidNumber" type="text" v-model="ruleForm.wuziUuidNumber" placeholder="物资编号"></input>
            </view>
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">物资名称</view>
                <input   disabled
                         :style='{"padding":"0 24rpx","boxShadow":"0px 6rpx 12rpx var(--publicSubColor)","margin":"6rpx 0rpx","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","color":"#333","textAlign":"left","borderRadius":"40rpx 0","borderWidth":"0","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                         :disabled="ro.wuziName" type="text" v-model="ruleForm.wuziName" placeholder="物资名称"></input>
            </view>
                <view
                        :style='{"boxShadow":"0 0 0px rgba(0,0,0,.3)","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(218, 220, 219, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"108rpx"}'
                        class="cu-form-group" @tap="wuziPhotoTap">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                          class="title">物资图片</view>
                    <view class="right-input" style="padding:0;textAlign:left">
                        <image
                                :style='{"width":"68rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","borderRadius":"100%","textAlign":"left","height":"68rpx"}'
                                class="avator" v-if="ruleForm.wuziPhoto" :src="baseUrl+ruleForm.wuziPhoto" mode="aspectFill">
                        </image>
                        <image  :style='{"width":"68rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","borderRadius":"100%","textAlign":"left","height":"68rpx"}'
                                class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
                    </view>
                </view>
					                <view :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                      class="cu-form-group">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                          class="title">物资类型</view>
                    <picker @change="wuziTypesChange" :value="wuziTypesIndex" :range="wuziTypesOptions" range-key="indexName">
                        <view
                                :style='{"padding":"0 24rpx","boxShadow":"0px 6rpx 12rpx var(--publicSubColor)","margin":"6rpx 0rpx","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","color":"#333","textAlign":"left","borderRadius":"40rpx 0","borderWidth":"0","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                                class="uni-input">{{ruleForm.wuziTypes?ruleForm.wuziValue:"请选择物资类型"}}</view>
                    </picker>
                </view>
                <view
                        :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                        class="cu-form-group">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                          class="title">物资库存</view>
                    <input   disabled
                             :style='{"padding":"0 24rpx","boxShadow":"0px 6rpx 12rpx var(--publicSubColor)","margin":"6rpx 0rpx","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","color":"#333","textAlign":"left","borderRadius":"40rpx 0","borderWidth":"0","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                             :disabled="ro.wuziKucunNumber" type="number" v-model="ruleForm.wuziKucunNumber" placeholder="物资库存"></input>
                </view>
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"210rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">物资介绍</view>
                <textarea :style='{"padding":"0 24rpx","boxShadow":"0px 6rpx 12rpx var(--publicSubColor)","margin":"6rpx 0rpx","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","color":"#333","textAlign":"left","borderRadius":"40rpx 0","borderWidth":"0","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx","height":"200rpx"}'
                          :disabled="ro.wuziContent" v-model="ruleForm.wuziContent" placeholder="物资介绍"/>
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
					wuziUuidNumber: true,
					wuziName: false,
					wuziPhoto: false,
					wuziTypes: false,
					wuziKucunNumber: false,
					wuziContent: false,
					wuziDelete: false,
					insertTime: false,
					createTime: false,
        },
            ruleForm: {
					wuziUuidNumber: this.getUUID(),//数字
					wuziName: '',
					wuziPhoto: '',
					wuziTypes: '',//数字
					wuziValue: '',//数字对应的值
					wuziKucunNumber: '',
					wuziContent: '',
					wuziDelete: '',
					insertTime: '',
					createTime: '',
            },
            // 登陆用户信息
            user: {},
            wuziTypesOptions: [],
            wuziTypesIndex : 0,

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
		/*下拉框*/
			let wuziTypesParams = {
                page: 1,
                limit: 100,
                dicCode: 'wuzi_types',
            }
			let wuziTypes = await this.$api.page(`dictionary`, wuziTypesParams);
			this.wuziTypesOptions = wuziTypes.data.list


            // 如果是更新操作
            if (options.id) {
                this.ruleForm.id = options.id;
                // 获取信息
                let res = await this.$api.info(`wuzi`, this.ruleForm.id);
                this.ruleForm = res.data;
            }
            if(options.wuziId){
                this.ruleForm.wuziId = options.wuziId;
            }
            // 跨表
            // this.styleChange()
        },
        methods: {
            // 下拉变化
            wuziTypesChange(e) {
                this.wuziTypesIndex = e.target.value
                this.ruleForm.wuziValue = this.wuziTypesOptions[this.wuziTypesIndex].indexName
                this.ruleForm.wuziTypes = this.wuziTypesOptions[this.wuziTypesIndex].codeIndex
            },
            // styleChange() {
            // 	this.$nextTick(() => {
            // 		// document.querySelectorAll('.app-update-pv .cu-form-group .uni-yaoxianStyle-yaoxianStyle').forEach(el=>{
            // 		//   el.style.backgroundColor = this.addUpdateForm.yaoxianStyle.content.backgroundColor
            // 		// })
            // 	})
            // },
			wuziPhotoTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.wuziPhoto = 'upload/' + res.file;
                    _this.$forceUpdate();
                    _this.$nextTick(() => {
                        // _this.styleChange()
                    })
                });
            },
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
				if ((!this.ruleForm.wuziUuidNumber)) {
                    this.$utils.msg(`物资编号不能为空`);
                    return
                }
				if ((!this.ruleForm.wuziName)) {
                    this.$utils.msg(`物资名称不能为空`);
                    return
                }
				if ((!this.ruleForm.wuziPhoto)) {
                    this.$utils.msg(`物资图片不能为空`);
                    return
                }
				if ((!this.ruleForm.wuziKucunNumber) && (!this.$validate.isIntNumer(this.ruleForm.wuziKucunNumber)) && this.ruleForm.wuziKucunNumber >0) {
                    this.$utils.msg(`物资库存不能为空，不能小于0 格式为数字`);
                    return
                }
                if (this.ruleForm.id) {
                    await this.$api.update(`wuzi`, this.ruleForm);
                } else {
                    await this.$api.save(`wuzi`, this.ruleForm);
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