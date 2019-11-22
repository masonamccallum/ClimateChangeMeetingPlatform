$( document ).ready(function() {
    console.log( "ready!" );
    $.ajax({
        url: 'GetUserChannels',
        type: 'get',
        dataType: 'json',
        success: function (data) {
            var arr = [];
            Cookies.set('channels', JSON.stringify(data['channels']));
            data['channels'].forEach(function (value, index) {
                arr.push(   '<div class="w3-third w3-padding-24">'+
                            '    <div class="w3-card w3-btn w3-padding-small">'+
                            '    <img src="images/img_5terre.jpg" style="width:100%">'+
                            '        <div class="w3-container">'+
                            '        <h4>'+value['channel_name']+'</h4>'+
                            '        </div>'+
                            '    </div>'+
                            '</div>'
                        );
            });
            arr.push(   '<div class="w3-third w3-padding-24">'+
                            '    <button id="create-channel-btn" onclick="showCreateChannel()" class="w3-card w3-btn w3-padding-small">'+
                            '        <div class="w3-container">'+
                            '        <h4>Create channel <i class="fa fa-plus fa-fw"></i></h4>'+
                            '        </div>'+
                            '    </button>'+
                            '</div>'
                        );
            $('#your-channels-header').after(arr);
            
        },
        error: function () {
             alert('Communication failed B');
         }
     });
     showChannelGrid();
     getUserList();
     $(":file").val(null);
     $(":file").change(function () {
        if (this.files && this.files[0]) {
            var reader = new FileReader();
            reader.onload = imageIsLoaded;
            reader.readAsDataURL(this.files[0]);
        }
    });
    
    $("#create-channel-form").submit( function () {
                return createChannelSubmit;
            });
});

function createChannelSubmit() {
    return true;
}

function showCreateChannel() {
    $('#channel-grid-panel').hide();
    $('#create-channel-panel').show();
    console.log(JSON.parse(Cookies.get('channels')));
}

function showChannelGrid() {
    $('#channel-grid-panel').show();
    $('#create-channel-panel').hide();
    $('#')
}

function imageIsLoaded(e) {
    $('#preview').attr('src', e.target.result);
};

function showChannelDetails(channelId) {
    
};

function getUserList() {
    $.ajax({
        url: 'GetUserList',
        type: 'get',
        dataType: 'json',
        success: function (data) {
            var content = '<p>'+
                        '<div class=w3-container"><table id="user-list" class="w3-table-all w3-hoverable">'+
                        '<thead>'+
                        '  <tr class="w3-light-grey">'+
                        '    <th>Username</th>'+
                        '    <th>Email</th>'+
                        '    <th>Invite</th>'+
                        '  </tr>'+
                        '</thead>';
            
            data['users'].forEach(function (value, index) {
                content += '<tr>'+
                            '   <td>'+value['username']+'</td>'+
                            '   <td>'+value['email']+'</td>'+
                            '   <td><input class="w3-check" type="checkbox"></td>'+
                            '</tr>'
                        ;
            });
            content += '</table></div></p>';
            $('#channel-desc-input').after(content);
            
        },
        error: function () {
             alert('Communication failed A');
         }
     });
}