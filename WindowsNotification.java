import java.awt.*;
import java.awt.TrayIcon.MessageType;

public class WindowsNotification {
    public static void addNotification(String title, String message) {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();

            Image image = Toolkit.getDefaultToolkit().getImage("icon.png");

            // TrayIcon nesnesi oluşturma
            TrayIcon trayIcon = new TrayIcon(image, "My App");
            trayIcon.setImageAutoSize(true);

            try {
                tray.add(trayIcon);
                trayIcon.displayMessage(title, message, MessageType.INFO);
            } catch (AWTException e) {
                System.err.println("TrayIcon eklenirken bir hata oluştu.");
            }
        } else {
            System.err.println("Sistem tepsisi (System Tray) desteklenmiyor.");
        }
    }
}
