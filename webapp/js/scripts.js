$(".answerWrite input[type=submit]").click(addAnswer);
function addAnswer(e) {
	e.preventDefault();
	var queryString = $("form[name=answer]").serialize();
	console.log(queryString)

	$.ajax({
		type : 'post',
		url : '/api/qna/addanswer',
		data : queryString,
		dataType : 'json',
		error : onError,
		success : onSuccess,
	});
}

function onSuccess(json, status) {
	var answerTemplate = $("#answerTemplate").html();
	var template = answerTemplate.format(json.writer,
			new Date(json.createdDate), json.contents, json.answerId,
			json.answerId);
	$(".qna-comment-slipp-articles").prepend(template);
}

function onError(xhr, status) {
	alert("error");
}

String.prototype.format = function() {
	var args = arguments;
	return this.replace(/{(\d+)}/g, function(match, number) {
		return typeof args[number] != 'undefined' ? args[number] : match;
	});
};
