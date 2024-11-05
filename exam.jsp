<div id="timer"></div>
<a href="LogoutServlet">Logout</a> 

<script>
    var timeLeft = 300; // in seconds
    var timerId = setInterval(function() {
        if (timeLeft <= 0) {
            clearInterval(timerId);
            document.getElementById("examForm").submit();
        } else {
            document.getElementById("timer").innerHTML = timeLeft + " seconds remaining";
        }
        timeLeft -= 1;
    }, 1000);
</script>
<div id="timer"></div>
<form id="examForm" action="ExamControllerServlet" method="POST">
    <!-- Render questions and options here -->
</form>
