
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;




public class TestMain   {

	public static void main(String[] args) throws Exception {
		String pV = "1.200.3";
		String iV = "1.199.3456";

		if (isGreater(pV, iV)) {   // last modified 1 hour or more ago
	  	System.out.println("PV > IV");
		} else {
	  	System.out.println("PV <= IV");
		}
	}	


	private static boolean isGreater(String packageVersion, String installedVersion) {																																					      // MM.mm.bb
		String packageMajorVersion = packageVersion.substring(0, packageVersion.indexOf("."));							        // MM
		String installedMajorVersion = installedVersion.substring(0, installedVersion.indexOf("."));
		String packageMinorVersion = packageVersion.substring(packageVersion.indexOf(".") + 1);                   // mm.bb
		String packageBuildVersion = packageMinorVersion.substring(packageMinorVersion.indexOf(".") + 1);					// bb
		String installedMinorVersion = installedVersion.substring(installedVersion.indexOf(".") + 1);
		String installedBuildVersion = installedMinorVersion.substring(installedMinorVersion.indexOf(".") + 1);
		packageMinorVersion = packageMinorVersion.substring(0, packageMinorVersion.indexOf("."));									// mm
		installedMinorVersion = installedMinorVersion.substring(0, installedMinorVersion.indexOf("."));
		int integerPackagerVersion = (Integer.parseInt(packageMajorVersion) * 10000000) + (Integer.parseInt(packageMinorVersion) * 10000) + (Integer.parseInt(packageBuildVersion));
		int integerInstalledVersion = (Integer.parseInt(installedMajorVersion) * 10000000) + (Integer.parseInt(installedMinorVersion) * 10000) + (Integer.parseInt(installedBuildVersion));
			System.out.println("Int Package Version" + integerPackagerVersion);
			System.out.println("Int Install Version" + integerInstalledVersion);
		return integerPackagerVersion > integerInstalledVersion;


		

	}
	

}
