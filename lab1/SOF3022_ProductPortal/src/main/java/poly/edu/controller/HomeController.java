package poly.edu.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {

	// GET /home/index -> templates/home/index.html
	@GetMapping("/index")
	public String index(Model model) {
		addCommonAttributes(model);
		return "home/index";
	}

	// GET /home/about -> templates/home/about.html
	@GetMapping("/about")
	public String about(Model model) {
		addCommonAttributes(model);
		return "home/about";
	}

	// GET /home/help -> templates/home/help.html
	@GetMapping("/help")
	public String help(Model model) {
		addCommonAttributes(model);
		return "home/help";
	}

	@GetMapping("/sanpham")
	public String sanpham(Model model) {
		addCommonAttributes(model);
		return "home/sanpham";
	}

	// Ca 3 trang deu hien thi cung 4 gia tri nay nen gom vao mot cho
	private void addCommonAttributes(Model model) {
		model.addAttribute("appName", "Product Portal");
		model.addAttribute("subject", "SOF3022 - Spring Boot MVC");
		model.addAttribute("semester", "Summer 2026");
		model.addAttribute("message", "Chào mừng bạn đến với hệ thống quản lý sản phẩm");
	}

	@GetMapping("/page")
	public String page(@RequestParam("page") Optional<Integer> optPage, Model model) {
		int pageNo = optPage.orElse(42);
		addCommonAttributes(model);
		model.addAttribute("pageNo", pageNo);
		return "home/page";
	}

}
