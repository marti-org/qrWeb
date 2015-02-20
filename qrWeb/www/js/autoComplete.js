$(function() {
    var availableTags = [
        "Mineral water",
        "Sparkling water",
        "Fresh water"
    ];
    $( "#tags" ).autocomplete({
        source: availableTags
    });
});