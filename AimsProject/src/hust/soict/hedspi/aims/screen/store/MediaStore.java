package hust.soict.hedspi.aims.screen.store;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class MediaStore extends JPanel {
	private Media media;

	public MediaStore(Media media) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		if(media instanceof Playable) {
			JButton playButton = new JButton("Play");
			playButton.addActionListener(e ->{
				JDialog playDialog = new JDialog();
				playDialog.setTitle("Play media");
				playDialog.setSize(new Dimension(500, 300));
				playDialog.setLayout(new BorderLayout());
				
				JLabel messageLabel = new JLabel("Playing "+ media.getTitle()+" ...", SwingConstants.CENTER);
	            messageLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	            playDialog.add(messageLabel, BorderLayout.CENTER);

	            JButton closeButton = new JButton("Close");
	            closeButton.setSize(50,20);
	            closeButton.addActionListener(event -> playDialog.dispose());
	            playDialog.add(closeButton, BorderLayout.SOUTH);

	            // Make the dialog visible
	            playDialog.setVisible(true);
			});
			container.add(playButton);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}
