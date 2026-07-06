public class Library_Management_System
{
    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                new LibraryGUI();
            }
        }
        );
    }
}