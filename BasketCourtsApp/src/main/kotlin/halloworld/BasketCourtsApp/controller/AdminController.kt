package halloworld.BasketCourtsApp.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AdminController {
    @GetMapping("/admin/page")
    fun getAdminPage(): String {
        return "admin"
    }
}