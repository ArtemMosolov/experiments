package week_1.core.general.i18n_i10n;

import java.util.Locale;
import java.util.ResourceBundle;

/*
 * Интернационализация - это процесс разработки приложения такой структуры, при
 * которой дополнение нового языка не требует перестройки и перекомпиляции
 * (сборки) всего приложения. 
 * 
 * Локализация предполагает адаптацию интерфейса
 * приложения под несколько языков. Добавление нового языка может внести
 * определенные сложности в локализацию интерфейса.
 */

public class I18N_I10N {

	public static void main(String[] args) {
		// default locale
		ResourceBundle bundle = ResourceBundle.getBundle("ApplicationMessages");
		// Get ResourceBundle with Locale that are already defined
		ResourceBundle bundleFR = ResourceBundle.getBundle("ApplicationMessages", Locale.FRANCE);
		// Get resource bundle when Locale needs to be created
		ResourceBundle bundleSWE = ResourceBundle.getBundle("ApplicationMessages", new Locale("sv", "SE"));

		// lets print some messages
		printMessages(bundle);
		printMessages(bundleFR);
		printMessages(bundleSWE);

	}

	private static void printMessages(ResourceBundle bundle) {
		System.out.println(bundle.getString("CountryName"));
		System.out.println(bundle.getString("CurrencyCode"));
	}

}

