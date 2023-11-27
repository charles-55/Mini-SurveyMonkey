$(document).ready(function() {
    $('#add-option-btn').hide();

    $('#questions-container').on('change', '.question-set select.question-sel-type', function() {
        // Find the parent question-set fieldset
        let questionSet = $(this).closest('.question-set');

        // Hide all question-type-input fieldsets within the current question set
        questionSet.find('.question-type-inputs').hide();

        // Get the selected question-type value
        let selectedValue = $(this).val();

        if (selectedValue === 'range') {
            questionSet.find('.question-type-inputs#range-question-inputs').show();
            $('#add-option-btn').hide();
        } else if (selectedValue === 'option') {
            questionSet.find('.question-type-inputs#mchoice-question-inputs').show();
            $('#add-option-btn').show();
        }
    });

    $('#add-question-btn').on('click', function() {
        // Clone the original element
        let originalQuestionSet = $('.question-set:last');
        let clonedQuestionSet = originalQuestionSet.clone();

        clonedQuestionSet.find('input').val('');
        clonedQuestionSet.find('.question-type-inputs').hide();

        // Append the cloned element to the body or another container
        originalQuestionSet.after('<br>');
        $('#questions-container').append(clonedQuestionSet);
    });

    // Event handler for adding a new option
    $('#add-option-btn').on('click', function() {
        // Find the parent question-set
        let originalQuestionSet = $('.question-type-inputs:last');

        // Clone the original question-set
        let clonedQuestionSet = originalQuestionSet.clone();

        // Reset values and hide additional input fields in the cloned question-set
        clonedQuestionSet.find('input').val('');
        clonedQuestionSet.find('.question-type-inputs').hide();

        // Append the cloned question-set to the container
        originalQuestionSet.after('<br>');
        $('#questions-container').append(clonedQuestionSet);
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