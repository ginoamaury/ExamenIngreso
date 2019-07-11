package dominio;

import java.util.Calendar;
import java.util.Date;

import dominio.excepcion.PrestamoException;
import dominio.repositorio.RepositorioLibro;
import dominio.repositorio.RepositorioPrestamo;

public class Bibliotecario{

	public static final String EL_LIBRO_NO_SE_ENCUENTRA_DISPONIBLE = "El libro no se encuentra disponible";
	public static final String IS_PALINDROME = "los libros palíndromos solo se pueden utilizar en la biblioteca";

	private RepositorioLibro repositorioLibro;
	private RepositorioPrestamo repositorioPrestamo;

	public Bibliotecario(RepositorioLibro repositorioLibro, RepositorioPrestamo repositorioPrestamo) {
		this.repositorioLibro = repositorioLibro;
		this.repositorioPrestamo = repositorioPrestamo;

	}

	public void prestar(String isbn, String nombreUsuario, Date date)  {
		
		if(isPalindrome(isbn)){
			throw new PrestamoException(IS_PALINDROME);
		}
		
		if(isBorrowed(isbn)){
			throw new PrestamoException(EL_LIBRO_NO_SE_ENCUENTRA_DISPONIBLE);
		}
		
		Date returnDate = returnDate(isbn,date);
		Libro book = repositorioLibro.obtenerPorIsbn(isbn);
		Prestamo borrow = new Prestamo(date,book,returnDate,nombreUsuario);
		repositorioPrestamo.agregar(borrow);

	}
	
	public boolean isBorrowed (String isbn){
		boolean isBorrowed = false;
		if (repositorioPrestamo.obtenerLibroPrestadoPorIsbn(isbn)!=null) isBorrowed=true;
		return isBorrowed;
	}
	
	public boolean isPalindrome (String isbn){
		
		int ini = 0;
		int last = isbn.length()-1;
		boolean isPalindrom = true;
		
		 while((ini<last) && isPalindrom){
	            if(isbn.charAt(ini)==isbn.charAt(last)){
	                ini++;
	                last--;
	            }else{
	                isPalindrom = false;
	                return isPalindrom;
	               
	       
	            }
	        }
		 
		 return isPalindrom;
		
	}
	
	public Date returnDate (String isbn, Date actualDate){
		Date returnDate = null;
		if(addDigits(isbn)>30){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(actualDate);
			calendar.add(Calendar.DAY_OF_YEAR, 15);
			if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
				calendar.add(Calendar.DAY_OF_YEAR, 1);
			}
			returnDate = calendar.getTime();
		}
		return returnDate;
	}
	
	
	public int addDigits (String isbn){
		int total=0;
		
		for(int i=0; i<isbn.length();i++){
			if(isNumber(isbn.charAt(i))){
				total += Integer.parseInt(""+isbn.charAt(i));
			}
		}
		return total;
	}
	
	public boolean isNumber (char digit){
		try{
			Integer.parseInt(""+digit);
			return true;
		}catch (NumberFormatException e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean esPrestado(String isbn) {
		boolean isBorrowed = false;
		if (repositorioPrestamo.obtenerLibroPrestadoPorIsbn(isbn)!=null) isBorrowed=true;
		return isBorrowed;
	}

}
