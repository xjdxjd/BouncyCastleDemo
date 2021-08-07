
function generateKey(URL, keyElem){
    $.get({
        url:URL,
        dataType: 'json',
        success: function (res) {
            if(res.code == code_seccuss){
                layer.msg('code: '+res.code+', message: '+res.message);
                keyElem.val(res.data.key);
            }else{
                layer.msg('code: '+res.code+', message: '+res.message);
            }
        },
        error: function (res) {
            layer.msg('code: '+res.code+', message: '+res.message);
        }
    });
}

function encrypt(URL, keyElem, proElem, cipElem){
    if(keyElem.val() == null || keyElem.val() == ''){layer.msg('密钥未生成，请先生成密钥！');return false;}
    if(proElem.val() == null || proElem.val() == ''){layer.msg('明文消息未填写，请先填写明文消息！');return false;}
    $.post({
        url: URL,
        data:{
            'key': keyElem.val(),
            'protext': proElem.val()
        },
        dataType: 'json',
        success: function (res) {
            if(res.code == code_seccuss){
                layer.msg('code: '+res.code+', message: '+res.message);
                cipElem.val(res.data.ciphertext);

            }else{
                layer.msg('code: '+res.code+', message: '+res.message);
            }
        },
        error: function (res) {
            layer.msg('code: '+res.code+', message: '+res.message);
        }
    });
}

function decrypt(URL, keyElem, proElem, cipElem){
    if(keyElem.val() == null || keyElem.val() == ''){layer.msg('密钥为空，请正确填写密钥！');return false;}
    if(cipElem.val() == null || cipElem.val() == ''){layer.msg('密文内容未填写，请先添加密文内容！');return false;}
    $.post({
        url: URL,
        data:{
            'key': keyElem.val(),
            'ciptext': cipElem.val()
        },
        dataType: 'json',
        success: function (res) {
            if(res.code == code_seccuss){

                layer.msg('code: '+res.code+', message: '+res.message);
                proElem.val(res.data.ciphertext);

            }else{
                layer.msg('code: '+res.code+', message: '+res.message);
            }
        },
        error: function (res) {
            layer.msg('code: '+res.code+', message: '+res.message);
        }
    });
}