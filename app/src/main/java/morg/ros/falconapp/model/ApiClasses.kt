package morg.ros.falconapp.model

public class ApiClasses {
    data class Rocket(

            var mission_name: String,
            var launch_date_utc: String,
            var launch_success: Boolean,
            var links: Link
    )

    data class Link(

            var mission_patch: String
    )

}