AJS.$("#stage-dialog-show-button").on('click', function(e) {
    e.preventDefault();
    AJS.dialog2("#stage-dialog").show();
});

// Hides the dialog
AJS.$("#dialog-submit-button").on('click', function (e) {
    e.preventDefault();
    AJS.dialog2("#stage-dialog").hide();
});