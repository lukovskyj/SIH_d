
function doAjaxPost() {
    let test_id = $('#test_id').val();

    $.ajax({
        type: "GET",
        url: "/rest",
        data: "test_id=" + test_id,
        success: function(response){
            console.log(response)
            let validation = eval(response);
            let correctAnswers = validation.correct_answer
            for (let i = 0; i < correctAnswers.length; i++ ){
                if ($("#question_" + i).val() !== correctAnswers[i]){
                    $("#label_for_question_" + i).text("Правильна відповідь: \"" + correctAnswers[i] + "\"")
                        .removeClass("d-none");
                    $("#question_" + i).addClass("is-invalid")
                }
                else {
                    console.log("VALID INPUT")
                    $("#label_for_question_" + i)
                        .addClass("d-none");
                    $("#question_" + i).addClass("is-valid")
                }
            }
            console.log(validation.id)
        },
        error: function(e){
            return null;
        }
    });
}
