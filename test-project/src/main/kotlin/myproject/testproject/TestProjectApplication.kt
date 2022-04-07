package myproject.testproject


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.repository.CrudRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@SpringBootApplication
class TestProjectApplication

fun main(args: Array<String>) {
	runApplication<TestProjectApplication>(*args)
}


@Entity
public class Employee{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private var id: Int? = null
	private var name: String? = null
	private var age: Int? = null
	private var email: String? = null

	fun getId(): Int? {
		return id
	}

	fun setId(id: Int?) {
		this.id = id
	}

	fun getName(): String? {
		return name
	}

	fun setName(name: String?) {
		this.name = name
	}

	fun getAge(): Int? {
		return age
	}

	fun setAge(age: Int?) {
		this.age = age
	}


	fun getEmail(): String? {
		return email
	}

	fun setEmail(email: String?) {
		this.email = email
	}
}

interface UserRepository : CrudRepository<Employee?, Int?>{

}


@RestController
class Controller{
	@Autowired
	val Repository: UserRepository? = null
	@PostMapping("/post")
	fun addNew(@RequestParam name: String?,@RequestParam age: Int?, @RequestParam email: String?): String{
		val n=Employee()
		n.setName(name)
		n.setAge(age)
		n.setEmail(email)
		Repository?.save(n)
		return "Employee details added"
	}

	@GetMapping("/get")
	fun getEmp(): MutableIterable<Employee?> {
		return Repository!!.findAll()
	}

}







