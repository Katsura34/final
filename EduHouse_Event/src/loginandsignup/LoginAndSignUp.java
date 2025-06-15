package loginandsignup;

import java.io.File;
public class LoginAndSignUp {
    private static Process proxyProcess;

    public static void main(String[] args) {
        startCloudSQLProxy();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (proxyProcess != null && proxyProcess.isAlive()) {
                proxyProcess.destroy();
                System.out.println("🛑 Proxy terminated.");
            }
        }));

        try { Thread.sleep(2000); } catch (Exception e) { }

        Login loginFrame = new Login();
        loginFrame.setVisible(true);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
    }

    private static void startCloudSQLProxy() {
        try {
            String baseDir = System.getProperty("user.dir");
            String proxyPath = baseDir + File.separator + "lib" + File.separator + "cloud-sql-proxy.x64.exe";
            String keyPath = baseDir + File.separator + "lib" + File.separator + "proxy" + File.separator + "key.json";

            ProcessBuilder pb = new ProcessBuilder(
                proxyPath,
                "elite-mix-462811-c1:asia-east1:jesonserver",
                "--credentials-file=" + keyPath
            );

            pb.redirectOutput(ProcessBuilder.Redirect.DISCARD);
            pb.redirectError(ProcessBuilder.Redirect.DISCARD);

            proxyProcess = pb.start();
            System.out.println("✅ Cloud SQL Proxy started.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
