var lastSelectedRow;
var table = document.getElementById('entityTable');
var trs = table.querySelectorAll('tr[name="entityRow"]');

var lmd = document.getElementById('launchModalDelete');

lmd.disabled = true;

for (var j = 0; j < trs.length; j++) {
    trs[j].onclick = function () {
        if (window.event.ctrlKey) {
            toggleRow(this);
        }

        if (window.event.button === 0) {
            if (!window.event.ctrlKey && !window.event.shiftKey) {
                clearAll();
                toggleRow(this);
            }

            if (window.event.shiftKey) {
                selectRowsBetweenIndexes([lastSelectedRow.rowIndex, this.rowIndex])
            }
        }
        var id = getEntityIdFromInputs(document.querySelectorAll('tr[clicked] > input[name="selectedEntitySingleId"]'));
        if (id.length < 2){
            setButtonsSingleId(id);
            setButtonsMultiId(id);
        } else {
            setButtonsSingleId(-1);
            setButtonsMultiId(id);
        }
        return true;
    }
}

function toggleRow(row) {
    if (!row.getAttribute('clicked')) {
        row.setAttribute('clicked', '');
    } else {
        row.removeAttribute('clicked');
    }
    lastSelectedRow = row;
}

function selectRowsBetweenIndexes(indexes) {
    indexes.sort(function(a, b) {
        return a - b;
    });

    for (var i = indexes[0]; i <= indexes[1]; i++) {
        trs[i-1].setAttribute('clicked', '');
    }
}

function clearAll() {
    for (var i = 0; i < trs.length; i++) {
        trs[i].removeAttribute('clicked');
    }
}

function getEntityIdFromInputs(idInputs){
    var ids = [];
    for (var i = 0; i < idInputs.length; i++){
        ids.push(idInputs[i].value);
    }
    return ids;
}

function setButtonsSingleId(id) {
    var entityIdInputs = document.getElementById('clickedRowButtons').querySelectorAll('input[name="selectedEntitySingleId"]');
    if (entityIdInputs){
        entityIdInputs.forEach(function (t) {
                t.value = id;
                lmd.disabled = false;
            }
        );
    }
}

function setButtonsMultiId(ids) {
    var entityIdInputs = document.getElementById('clickedRowButtons').querySelectorAll('input[name="selectedEntityMultiId"]');
    if (entityIdInputs){
        entityIdInputs.forEach(function (t) {
                t.value = ids;
            }
        );
    }
}

function validateSubmit(event) {
    event.preventDefault();
    var formEntityId = this.querySelector('input[name="selectedEntitySingleId"]').value;
    if (formEntityId == -1) {
        return;
    }

    this.submit();
}



