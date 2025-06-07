const base = {
    get() {
        return {
            url : "http://localhost:8080/xiaoquwuyexinguanwuzi/",
            name: "xiaoquwuyexinguanwuzi",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/xiaoquwuyexinguanwuzi/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "小区物业新冠疫情物资管理平台"
        } 
    }
}
export default base
