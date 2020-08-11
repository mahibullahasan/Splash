import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Main extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Timer tm = new Timer(30, this);
	int time = 0;
	private JProgressBar progressBar;
	private JLabel label;

	@Override
	public void actionPerformed(ActionEvent e) {
		time++;
		if (time > 100) {
			tm.stop();
			
		} else {
			progressBar.setValue(time);
			label.setText(String.valueOf(time) + "%");
		}

	}

	/**
	 * Create the frame.
	 */
	public Main() {
		design();
		tm.start();
		sound();
	}

	public void design() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				progressBar = new JProgressBar();
				progressBar.setBounds(139, 121, 146, 37);
				contentPane.add(progressBar);
				
						label = new JLabel("0%");
						label.setHorizontalAlignment(SwingConstants.CENTER);
						label.setBounds(139, 121, 146, 37);
						contentPane.add(label);
	}

	
	public void sound() {
		try {
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(Main.class.getResource("/sound/start.wav"));
			clip.open(inputStream);
			clip.start();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
