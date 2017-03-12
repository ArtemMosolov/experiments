package week_1.core.general.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* 
 
	Before Sort by id : 
	Country Id: 1||Country name: India
	Country Id: 4||Country name: China
	Country Id: 3||Country name: Nepal
	Country Id: 2||Country name: Bhutan
	After Sort by id: 
	Country Id: 1|| Country name: India
	Country Id: 2|| Country name: Bhutan
	Country Id: 3|| Country name: Nepal
	Country Id: 4|| Country name: China
	After Sort by name: 
	Country Id: 2|| Country name: Bhutan
	Country Id: 4|| Country name: China
	Country Id: 1|| Country name: India
	Country Id: 3|| Country name: Nepal

*/

public class ComparatoExample {

	public static void main(String[] args) {
		CountryA indiaCountry = new CountryA(1, "India");
		CountryA chinaCountry = new CountryA(4, "China");
		CountryA nepalCountry = new CountryA(3, "Nepal");
		CountryA bhutanCountry = new CountryA(2, "Bhutan");

		List<CountryA> listOfCountries = new ArrayList<CountryA>();
		listOfCountries.add(indiaCountry);
		listOfCountries.add(chinaCountry);
		listOfCountries.add(nepalCountry);
		listOfCountries.add(bhutanCountry);

		System.out.println("Before Sort by id : ");
		for (int i = 0; i < listOfCountries.size(); i++) {
			CountryA country = (CountryA) listOfCountries.get(i);
			System.out.println(
					"Country Id: " + country.getCountryId() + "||" + "Country name: " + country.getCountryName());
		}
		Collections.sort(listOfCountries, new CountrySortByIdComparator());

		System.out.println("After Sort by id: ");
		for (int i = 0; i < listOfCountries.size(); i++) {
			CountryA country = (CountryA) listOfCountries.get(i);
			System.out.println(
					"Country Id: " + country.getCountryId() + "|| " + "Country name: " + country.getCountryName());
		}

		// Sort by countryName
		Collections.sort(listOfCountries, new Comparator<CountryA>() {

			@Override
			public int compare(CountryA o1, CountryA o2) {
				return o1.getCountryName().compareTo(o2.getCountryName());
			}
		});

		System.out.println("After Sort by name: ");
		for (int i = 0; i < listOfCountries.size(); i++) {
			CountryA country = (CountryA) listOfCountries.get(i);
			System.out.println(
					"Country Id: " + country.getCountryId() + "|| " + "Country name: " + country.getCountryName());
		}
	}

}

class CountryA {
	int countryId;
	String countryName;

	public CountryA(int countryId, String countryName) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}

class CountrySortByIdComparator implements Comparator<CountryA> {

	@Override
	public int compare(CountryA country1, CountryA country2) {

		return (country1.getCountryId() < country2.getCountryId()) ? -1
				: (country1.getCountryId() > country2.getCountryId()) ? 1 : 0;
	}

}