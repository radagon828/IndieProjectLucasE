$().ready(function() {
    $("#submitRunForm").validate({
        rules: {
            platform: {
                required: true,
            },
            time: {
                required: true,
                minlength: 9,
            },
            videoLink: {
                required: true,
            }
        },
        messages: {
            platform: {
                required: "Please enter the name of the platform you performed the run on",
            },
            time: {
                required: "Please provide you run time",
                minlength: "Your time must follow the HH:mm:ss format"
            },
            videoLink: {
                required: "Please provide an embedded youtube link",
            }
        }
    });
})