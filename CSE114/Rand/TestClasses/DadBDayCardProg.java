import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

/**
 * GGBGDC GGBGDC DDDBGFE GGBGDC
 * 54, 54, 56, 54, 59, 58,
 * 54, 54, 56, 54, 61, 59
 */

public class DadBDayCardProg {
    public static void main(String[] args) {
        int[] notes = {54, 54, 56, 54, 59, 58, 58,
                54, 54, 56, 54, 61, 59, 59,
                54, 54, 66, 63, 59, 58,
                56, 64, 64, 63, 59, 58, 59};
        String[] sylabols = {"hap", "py ", "birth ", "day ", "to ", "you\n", "",
                "hap", "py ", "birth ", "day ", "to ", "you\n", "",
                "hap", "py ", "birth ", "day ", "dear ", "dad\n",
                "hap", "py ", "birth ", "day ", "to ", "you", ""};
        int power = 100;
        try {
            Synthesizer synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            MidiChannel channel = synthesizer.getChannels()[0];
            for (int i = 0; i < notes.length; i++) {
                System.out.print(sylabols[i]);
                channel.noteOn(notes[i], power);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                } finally {
                    channel.noteOff(notes[i]);
                }
            }
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

}

