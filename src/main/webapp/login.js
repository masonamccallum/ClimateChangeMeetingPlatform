$(document).ready(function () {
    $("#login-form").submit( function () {
                return true;
            });
});

//function checkPassword() {
//    var username = $('#username').val();
//    var password = $('#password').val();
//    
//    $.ajax({    
//        url: 'CheckPassword?username='+username+'&password=' + password,
//        type: 'get',
//        dataType: 'text',
//        success: function (data) {
//            console.log(data);
//            return true;
//        },
//        error: function () {
//             alert('Communication failed');
//         }
//     });
//}