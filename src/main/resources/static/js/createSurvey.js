$(document).ready(function() {

    $('#add-question-btn').on('click', function() {
        // Clone the original element
        let originalFields = $('.question-set:last');
        let clonedFields = originalFields.clone();

        clonedFields.find('input').val('');
        let questionNumber = originalFields.find('legend').text().match(/\d+/); // Extract the current question number
        let newQuestionNumber = questionNumber ? parseInt(questionNumber[0]) + 1 : 1; // Increment the question number
        clonedFields.find('legend').text('Question ' + newQuestionNumber); // Update legend text

        // Append the cloned element to the body or another container
        originalFields.after('<br>');
        $('#questions-container').append(clonedFields);
    });

    $('#rem-question-btn').on('click', function() {
        let container = $('#questions-container');
        if (container.children('fieldset').length > 1) {
            container.children('br:last').remove();
            container.children('.question-set:last').remove();
        }
    });

    $("#submit-survey-btn").on("click", function() {
        $("#survey-form").submit();
    });

});