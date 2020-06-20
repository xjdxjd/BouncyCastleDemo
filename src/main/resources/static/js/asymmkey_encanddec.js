function genenateKey(URL, length, keyElem){
    $.get({
        url:URL+length,
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

function encrypt(URL, keyElem, proElem, cipElem) {

}

function decrypt(URL, keyElem, proElem, cipElem){

}