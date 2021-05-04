$().ready(function() {
    $("#submitTechForm").validate({
        rules: {
            platform: {
                required: true,
            },
            runTime: {
                required: true,

            },
            videoLink: {
                required: true,
            }
        },
        messages: {
            platform: {
                required: "Please enter the name of the platform you performed the run on",
            },
            runTime: {
                required: "Please provide you run time",
            },
            videoLink: {
                required: "Please provide an embedded youtube link",
            }
        }
    });
})