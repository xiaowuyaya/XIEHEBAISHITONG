// pages/register/register.js

var userInfo;
var id

var pageObject = {
  
  onGotUserInfo: function (e) {
    console.log(e.detail.errMsg)
    console.log(e.detail.userInfo)
    console.log(e.detail.rawData)

    userInfo = e.detail.userInfo
    var errMsg = e.detail.errMsg

   
  },


  formSubmit: function (e) {
    console.log(e.detail.value)
    id = e.detail.value
    wx.request({
      url: 'http://localhost:8080/wx_war_exploded/GetUserInfoServlet',
      method: "post",
      data: {
        id,
        userInfo
      }
    })
  },



}




Page(
  pageObject

)