$().ready(function() {
    $("#submitTechForm").validate({
        rules: {
            videoTitle: {
                required: true,
            },
            description: {
                required: true,

            },
            videoLink: {
                required: true,
            }
        },
        messages: {
            videoTitle: {
                required: "Please enter your video title",
            },
            runTime: {
                required: "Please provide a video description",
            },
            videoLink: {
                required: "Please provide an embedded youtube link",
            }
        }
    });
})