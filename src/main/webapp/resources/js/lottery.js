$(document).ready(function() {

	$('.kill').click(function() {
		var killValue = $(this).val();
		var url = "/lottery/kill/" + killValue;
		$(location).attr('href', url);
	});

	$('.allkill').click(function() {
		var killValue = $(this).val();
		var url = "/lottery/killall/" + killValue;
		$(location).attr('href', url);
	});

	$('#mergeAllKill').click(function() {
		var killValue = $(this).val();
		var url = "/lottery/allMerge/" + killValue;
		$(location).attr('href', url);
	});

	$('#showAllkill').click(function() {
		var killValue = $(this).val();
		var url = "/lottery/killall/" + killValue;
		$(location).attr('href', url);
	});

	$('#mergeKill').click(function() {
		var killValue = $(this).val();
		var url = "/lottery/merge/" + killValue;
		$(location).attr('href', url);
	});

	$('#showkill').click(function() {
		var killValue = $(this).val();
		var url = "/lottery/kill/" + killValue;
		$(location).attr('href', url);
	});
});
