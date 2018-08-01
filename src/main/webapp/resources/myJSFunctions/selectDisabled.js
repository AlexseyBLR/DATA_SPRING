function onChange() {
    var selectBox = document.getElementById('profile');
    var value = selectBox.options[selectBox.selectedIndex].value;

    if(value=='mathphys'){
        document.getElementById('mathResult').disabled = false;
        document.getElementById('physResult').disabled = false;

        document.getElementById('himResult').disabled = true;
        document.getElementById('biolResult').disabled = true;
        document.getElementById('englResult').disabled = true;

        document.getElementById('b1').disabled = false;
        document.getElementById('b2').disabled = false;
        document.getElementById('b3').disabled = false;
        document.getElementById('langResult').disabled = false;
    }
    if(value=='himbio'){
        document.getElementById('himResult').disabled = false;
        document.getElementById('biolResult').disabled = false;

        document.getElementById('mathResult').disabled = true;
        document.getElementById('physResult').disabled = true;
        document.getElementById('englResult').disabled = true;

        document.getElementById('b1').disabled = false;
        document.getElementById('b2').disabled = false;
        document.getElementById('b3').disabled = false;
        document.getElementById('langResult').disabled = false;
    }
    if(value=='mathlang'){
        document.getElementById('mathResult').disabled = false;
        document.getElementById('englResult').disabled = false;

        document.getElementById('physResult').disabled = true;
        document.getElementById('himResult').disabled = true;
        document.getElementById('biolResult').disabled = true;

        document.getElementById('b1').disabled = false;
        document.getElementById('b2').disabled = false;
        document.getElementById('b3').disabled = false;
        document.getElementById('langResult').disabled = false;
    }

}
function onLoad() {
    document.getElementById('mathResult').disabled = true;
    document.getElementById('physResult').disabled = true;
    document.getElementById('langResult').disabled = true;
    document.getElementById('himResult').disabled = true;
    document.getElementById('biolResult').disabled = true;
    document.getElementById('englResult').disabled = true;
}

function onButton() {
    document.getElementById('mathResult').disabled = false;
    document.getElementById('physResult').disabled = false;
    document.getElementById('langResult').disabled = false;
    document.getElementById('himResult').disabled = false;
    document.getElementById('biolResult').disabled = false;
    document.getElementById('englResult').disabled = false;
}