package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.brand.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.brand.GetByIdBrandResponse;
import kodlama.io.rentACar.business.responses.brand.GetByNameBrandResponse;
import kodlama.io.rentACar.business.responses.brand.GetByNameIsNotNullBrandResponse;
import kodlama.io.rentACar.business.responses.brand.GetByNameIsNullBrandResponse;
import kodlama.io.rentACar.entities.concretes.BrandDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController // annotation 
@RequestMapping("/api/brands")
public class BrandsController {
	private BrandService brandService;

	@GetMapping("/getbynameisnull")
	public List<GetByNameIsNullBrandResponse> getByNameIsNullBrandResponses() {
		return brandService.getByNameIsNullBrandResponses();
	}

	@GetMapping("/getbynameisnotnull")
	public List<GetByNameIsNotNullBrandResponse> getByNameIsNotNullBrandResponses() {
		return brandService.getByNameIsNotNullBrandResponses();
	}

	@GetMapping("/getbynameis")
	public List<GetByNameBrandResponse> getByNameBrandResponse(String name) {
		return brandService.getByNameBrandResponses(name);
	}

	@GetMapping("/getbynamestartingwith")
	public List<GetByNameBrandResponse> getByNameStartingWith(String name) {
		return brandService.findByNameStartingWithBrandResponse(name);
	}

	@GetMapping()
	public List<BrandDto> getAll() {
		return brandService.getAll();
	}

	@GetMapping("/{id}")
	public GetByIdBrandResponse getById(@PathVariable int id) {
		return brandService.getById(id);
	}

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}

	@PutMapping
	public void update(@RequestBody @Valid() UpdateBrandRequest updateBrandRequest) {
		this.brandService.update(updateBrandRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.brandService.delete(id);
	}

}
