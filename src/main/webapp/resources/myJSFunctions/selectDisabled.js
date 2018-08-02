function onChange() {
    var selectBox = document.getElementById('profile');
    var value = selectBox.options[selectBox.selectedIndex].value;

    var certResult = document.getElementById('cert');
    var mathResult = document.getElementById('math');
    var physResult = document.getElementById('phys');
    var langResult = document.getElementById('lang');
    var biolResult = document.getElementById('biol');
    var himResult = document.getElementById('him');
    var englResult = document.getElementById('engl');
    var buttonSave = document.getElementById('buttonSave');

    if (value == 'chose') {

        certResult.disabled = true;
        mathResult.disabled = true;
        physResult.disabled = true;
        langResult.disabled = true;
        biolResult.disabled = true;
        himResult.disabled = true;
        englResult.disabled = true;
        buttonSave.disabled = true;
    }

    if (value == 'mathphys') {

        certResult.style.display = 'block';
        langResult.style.display = 'block';
        mathResult.style.display = 'block';
        physResult.style.display = 'block';

        biolResult.style.display = 'none';
        himResult.style.display = 'none';
        englResult.style.display = 'none';

        buttonSave.style.display = 'block';
        buttonSave.disabled = false;
    }

    if (value == 'himbio') {
        certResult.style.display = 'block';
        langResult.style.display = 'block';
        biolResult.style.display = 'block';
        himResult.style.display = 'block';

        mathResult.style.display = 'none';
        physResult.style.display = 'none';
        englResult.style.display = 'none';

        buttonSave.style.display = 'block';
        buttonSave.disabled = false;

    }

    if (value == 'mathlang') {
        certResult.style.display = 'block';
        langResult.style.display = 'block';
        mathResult.style.display = 'block';
        englResult.style.display = 'block';

        biolResult.style.display = 'none';
        himResult.style.display = 'none';
        physResult.style.display = 'none';

        buttonSave.style.display = 'block';
        buttonSave.disabled = false;

    }
}

function onLoad() {

    var certResult = document.getElementById('cert');
    var mathResult = document.getElementById('math');
    var physResult = document.getElementById('phys');
    var langResult = document.getElementById('lang');
    var biolResult = document.getElementById('biol');
    var himResult = document.getElementById('him');
    var englResult = document.getElementById('engl');
    var buttonSave = document.getElementById('buttonSave');
    var buttonBack = document.getElementById('buttonBack');
    var buttonCancel = document.getElementById('buttonCancel');

    certResult.style.display = 'none';
    langResult.style.display = 'none';
    mathResult.style.display = 'none';
    physResult.style.display = 'none';
    englResult.style.display = 'none';
    biolResult.style.display = 'none';
    himResult.style.display = 'none';
    buttonSave.disabled = true;
    buttonBack.style.display = 'block';
    buttonBack.disabled = false
    buttonCancel.style.display = 'block';
    buttonCancel.disabled = false;
}
