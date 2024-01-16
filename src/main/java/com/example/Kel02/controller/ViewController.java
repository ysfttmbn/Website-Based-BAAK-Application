package com.example.Kel02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.Kel02.model.*;
import com.example.Kel02.service.BookingRuanganService;
import com.example.Kel02.service.IjinBermalamService;
import com.example.Kel02.service.IjinKeluarService;
import com.example.Kel02.service.ProdukService;
import com.example.Kel02.service.RuanganService;
import com.example.Kel02.service.SuratService;
@Controller
public class ViewController {
	@Autowired
	private ProdukService service;
	
	@Autowired
	private RuanganService ruanganService;
	
	@Autowired
	private SuratService servicesurat;
	
	@Autowired
	ProdukService produkService;
	
	@Autowired
	BookingRuanganService bookingruanganService;
	
	@Autowired
	private IjinKeluarService serviceijinkeluar;
	
	@Autowired
	private IjinBermalamService serviceijinbermalam;
	
	@RequestMapping("/add")
	public String showNewProductPage(Model model) {
		Produk product = new Produk();
		model.addAttribute("product", product);

		return "add_product";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") long id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Produk product = service.getProduk(id);
		mav.addObject("product", product);

		return mav;
	}
	
	@RequestMapping("/addruangan")
	public String showNewRuanganPage(Model model) {
		Ruangan ruangan = new Ruangan();
		model.addAttribute("ruangan", ruangan);

		return "add_ruangan";
	}

	@RequestMapping("/editruangan/{id}")
	public ModelAndView showEditRuanganPage(@PathVariable(name = "id") long id) {
		ModelAndView mav = new ModelAndView("edit_ruangan");
		Ruangan ruangan = ruanganService.getRuangan(id);
		mav.addObject("ruangan", ruangan);
		return mav;
	}
	@RequestMapping("/editsurat/{id}")
	public ModelAndView showEditSuratPage(@PathVariable(name = "id") long id) {
		ModelAndView mav = new ModelAndView("edit_surat");
		Surat surat = servicesurat.getSurat(id);
		mav.addObject("surat", surat);

		return mav;
	}
	@RequestMapping("/editijinkeluar/{id}")
	public ModelAndView showEditIjinKeluarPage(@PathVariable(name = "id") long id) {
		ModelAndView mav = new ModelAndView("edit_ijinkeluar");
		IjinKeluar ijinkeluar = serviceijinkeluar.getIjinKeluar(id);
		mav.addObject("ijinkeluar", ijinkeluar);
		return mav;
	}
	@RequestMapping("/editijinbermalam/{id}")
	public ModelAndView showEditIjinBermalamPage(@PathVariable(name = "id") long id) {
		ModelAndView mav = new ModelAndView("edit_ijinbermalam");
		IjinBermalam ijinbermalam = serviceijinbermalam.getIjinBermalam(id);
		mav.addObject("ijinbermalam", ijinbermalam);
		return mav;
	}
	@RequestMapping("/index2")
	public String showPage() {
		return "index2";
	}
	@RequestMapping("/index3")
	public String showPageRuangan() {
		return "index3";
	}
	@RequestMapping("/index4")
	public String showSurat() {
		return "index4";
	}
	@RequestMapping("/index5")
	public String showIjinKeluar() {
		return "index5";
	}
	@RequestMapping("/index6")
	public String showIjinBermalam() {
		return "index6";
	}
	@RequestMapping("/index7")
	public String showOrder() {
		return "index7";
	}
	@RequestMapping("/index8")
	public String showBooking() {
		return "index8";
	}
	
	@RequestMapping("/history")
	public String showHistory() {
		return "history_request";
	}
	
	@RequestMapping("/produkuser")
	public ModelAndView listProduk(Model model) {
		List<Produk> produkList = produkService.listAllProduk();
		model.addAttribute("produkList", produkList);
		return new ModelAndView("user-product", "model", model);
	}
	@RequestMapping("/ruanganuser")
	public ModelAndView listRuangan(Model model) {
		List<Ruangan> ruanganList = ruanganService.listAllRuangan();
		model.addAttribute("ruanganList", ruanganList);
		return new ModelAndView("user-ruangan", "model", model);
	}
	
	 @GetMapping("/orderproduct/{productId}")
	    public String orderProduct(@PathVariable Long productId) {
	        // Logic to handle the order for the product with the given productId
	        // You can add your business logic here
	        return "order-product"; // Return the name of the template or redirect to another page
	    }
	 @GetMapping("/bookingruang/{ruanganId}")
	 public String showBookingRuanganPage(@PathVariable Long ruanganId) {
	     // Logic to handle the booking for the ruangan with the given ruanganId
	     // You can add your business logic here
	     return "booking-ruangan"; // Return the name of the template or redirect to another page
	 }
	 

	 
	 @RequestMapping("/request-surat")
		public String showPageSurat() { 
			return "request-surat";
		}
	 
	 @RequestMapping("/requestijinkeluar")
		public String showPageIjinKeluar() { 
			return "request-ik";
		}
	 @RequestMapping("/requestijinbermalam")
		public String showPageIjinBermalam() { 
			return "request-ib";
		}
	 
		@RequestMapping("/editbookingruangan/{id}")
		public ModelAndView showEditBookingRuanganPage(@PathVariable(name = "id") long id) {
			ModelAndView mav = new ModelAndView("edit_bookingruangan");
			BookingRuangan bookingruangan = bookingruanganService.getBookingRuangan(id);
			mav.addObject("bookingruangan", bookingruangan);
			return mav;
		}
}
