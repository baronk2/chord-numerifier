import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Chord_Numerifier {

   public enum NaturalSharpFlat {
   
      NATURAL,
      SHARP,
      FLAT
   
   }

   public enum Mode {
      
      MAJOR,
      MINOR
   
   }

   public enum Key {
     
      C,
      D,
      E,
      F,
      G,
      A,
      B,
      
      CSHARP,
      DSHARP,
      ESHARP,
      FSHARP,
      GSHARP,
      ASHARP,
      BSHARP,
      
      CFLAT,
      DFLAT,
      EFLAT,
      FFLAT,
      GFLAT,
      AFLAT,
      BFLAT,
      
      CMINOR,
      DMINOR,
      EMINOR,
      FMINOR,
      GMINOR,
      AMINOR,
      BMINOR,
      
      CSHARPMINOR,
      DSHARPMINOR,
      ESHARPMINOR,
      FSHARPMINOR,
      GSHARPMINOR,
      ASHARPMINOR,
      BSHARPMINOR,
      
      CFLATMINOR,
      DFLATMINOR,
      EFLATMINOR,
      FFLATMINOR,
      GFLATMINOR,
      AFLATMINOR,
      BFLATMINOR
      
   }

   public static void main(String[] args) throws FileNotFoundException {
      
      try {
         
         String chordFileWithDirectoryString =
         "E:\\Kevin\\Music\\Chord_Numerifier\\Rocket_Man,_Elton_John,_Original_Chords.txt";
         
         File chordFile = new File(chordFileWithDirectoryString);
         Scanner chordFileScanner = new Scanner(chordFile);
         
         String chordFileNameString = chordFileWithDirectoryString.substring(
            chordFileWithDirectoryString.lastIndexOf("\\") + 1
         );
         
         String songNameAndArtistName = chordFileNameString.substring(
            0, chordFileNameString.indexOf(",_Original_Chords.txt")
         );
         
         String songName = songNameAndArtistName.substring(
            0, songNameAndArtistName.lastIndexOf(",_")
         ).replaceAll("_", " ");
        
         String artistName = songNameAndArtistName.substring(
            songNameAndArtistName.lastIndexOf(",_") + 2
         ).replaceAll("_", " ");
                  
         String currentReadLine = "";
         String currentReadLineNoSpaces = "";
         int nonSpaceCharsInCurrentReadLine;
         int spacesInCurrentReadLine;
         
         String currentPrintLine = "";
         
         Key keyEnum = Key.C;
         String keyString = "C";
         String keyNoteString = "C";
         int keyChromaticNoteDegree = 0;
         NaturalSharpFlat naturalSharpFlat = NaturalSharpFlat.NATURAL;
         Mode modeEnum = Mode.MAJOR;
         String modeString = "Major";
         
         
         int capoInt = 0;
         int writtenKeyChromaticNoteDegree = 0;
         
         boolean isChordLine = false;
         
         while (chordFileScanner.hasNextLine()) {
            
            currentReadLine = chordFileScanner.nextLine();
            
                        
            if (currentReadLine.length() > 5) {
            
               if(currentReadLine.substring(0, 5).equals("Key: ")) {
               
                  keyString = currentReadLine.substring(5);
                  
                  if (keyString.substring(keyString.length() - 1).equals("m")) {
                  
                     modeEnum = Mode.MINOR;
                     modeString = "Minor";
                     
                     keyNoteString = keyString.substring(0, keyString.indexOf("m"));
                  
                  } else {
                  
                     keyNoteString = keyString;
                  
                  }
                  
                  if (keyNoteString.equals("C") || keyNoteString.equals("B#")) {
                  
                     keyChromaticNoteDegree = 0;
                  
                  } else if (keyNoteString.equals("C#") || keyNoteString.equals("Db")) {
                  
                     keyChromaticNoteDegree = 1;
                  
                  } else if (keyNoteString.equals("D")) {
                  
                     keyChromaticNoteDegree = 2;
                  
                  } else if (keyNoteString.equals("D#") || keyNoteString.equals("Eb")) {
                  
                     keyChromaticNoteDegree = 3;
                  
                  } else if (keyNoteString.equals("E") || keyNoteString.equals("Fb")) {
                  
                     keyChromaticNoteDegree = 4;
                  
                  } else if (keyNoteString.equals("E#") || keyNoteString.equals("F")) {
                  
                     keyChromaticNoteDegree = 5;
                  
                  } else if (keyNoteString.equals("F#") || keyNoteString.equals("Gb")) {
                  
                     keyChromaticNoteDegree = 6;
                  
                  } else if (keyNoteString.equals("G")) {
                  
                     keyChromaticNoteDegree = 7;
                  
                  } else if (keyNoteString.equals("G#") || keyNoteString.equals("Ab")) {
                  
                     keyChromaticNoteDegree = 8;
                  
                  } else if (keyNoteString.equals("A")) {
                  
                     keyChromaticNoteDegree = 9;
                  
                  } else if (keyNoteString.equals("A#") || keyNoteString.equals("Bb")) {
                  
                     keyChromaticNoteDegree = 10;
                  
                  } else if (keyNoteString.equals("B") || keyNoteString.equals("Cb")) {
                  
                     keyChromaticNoteDegree = 11;
                  
                  }
                                 
               }
                           
            }
            
            if (currentReadLine.length() > 6) {
            
               if(currentReadLine.substring(0, 6).equals("Capo: ")) {
               
                  capoInt = Integer.parseInt(currentReadLine.substring(6, 7));
                                 
               }
                           
            }
            
            writtenKeyChromaticNoteDegree = (keyChromaticNoteDegree - capoInt) % 12;
            
            currentReadLineNoSpaces = currentReadLine.replaceAll(" ", "");
            
            nonSpaceCharsInCurrentReadLine = currentReadLineNoSpaces.length();
            spacesInCurrentReadLine = currentReadLine.length() - nonSpaceCharsInCurrentReadLine;
            
            currentPrintLine = currentReadLine;
            
            if ((spacesInCurrentReadLine > (2 * nonSpaceCharsInCurrentReadLine))
            && (nonSpaceCharsInCurrentReadLine > 0)) {
            
               isChordLine = true;
               
               currentPrintLine = "";
               
               for (int i = 0; i <; i++) {
                  
                  if (currentReadLine.substring(i, i + 1).equals(" ")) {
                  
                     currentPrintLine = currentPrintLine + " ";
                  
                  } else {
                  
                     
                  
                  }                  
                  
               }
            
            } else {
            
               isChordLine = false;
            
            }    
            
            System.out.println(currentPrintLine);
            //System.out.println("isChordLine: " + isChordLine);
                     
         }
         
         System.out.println();
         System.out.println("songName: " + songName);
         System.out.println("artistName: " + artistName);
         System.out.println();
         System.out.println("keyString: " + keyString);
         System.out.println("keyChromaticNoteDegree: " + keyChromaticNoteDegree);
         System.out.println("modeEnum: " + modeEnum.name());
         System.out.println("modeString: " + modeString);
         System.out.println("naturalSharpFlat: " + naturalSharpFlat.name();
         System.out.println();
         System.out.println("capoInt: " + capoInt);
         System.out.println("writtenKeyChromaticNoteDegree: " + writtenKeyChromaticNoteDegree);
               
      } catch (FileNotFoundException exception) {
      
         System.out.println("Chord file not found.");
      
      }

   }
     
}