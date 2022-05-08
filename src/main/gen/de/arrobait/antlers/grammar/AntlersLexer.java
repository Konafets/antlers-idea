/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package de.arrobait.antlers.grammar;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;

import java.util.ArrayDeque;
import java.util.Deque;

import static de.arrobait.antlers.psi.AntlersTypes.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>AntlersLexer.flex</tt>
 */
public class AntlersLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int ANTLERS_COMMENT = 2;
  public static final int ANTLERS_NODE = 4;
  public static final int PROPERTY_ACCESS = 6;
  public static final int SINGLE_STRING = 8;
  public static final int DOUBLE_STRING = 10;
  public static final int PHP_ECHO = 12;
  public static final int PHP_RAW = 14;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6,  6,  7, 7
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [10, 6, 5]
   * Total runtime size is 4224 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[(ZZ_CMAP_Z[ch>>11]<<6)|((ch>>5)&0x3f)]<<5)|(ch&0x1f)];
  }

  /* The ZZ_CMAP_Z table has 544 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\15\5\1\7\1\10\11\5\1\11\1\12\1\5\1\13\1\14\11"+
    "\5\1\15\14\5\1\16\2\5\1\17\u01e2\5");

  /* The ZZ_CMAP_Y table has 1024 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\55\6\1\7\3\6\1\10\6\6\1\7\14\6\1\11\3\6\1\11\3\6"+
    "\1\11\3\6\1\11\3\6\1\11\3\6\1\11\3\6\1\11\3\6\1\11\3\6\1\11\3\6\1\11\2\6\1"+
    "\10\3\6\1\10\2\6\1\7\10\6\1\7\1\6\1\10\57\6\1\5\12\6\1\7\1\10\11\6\1\11\3"+
    "\6\1\10\5\6\1\12\5\6\1\10\2\6\1\10\4\6\1\12\35\6\1\13\1\14\1\15\175\6\1\5"+
    "\160\6\1\7\24\6\1\10\1\6\1\7\5\6\2\10\2\6\1\10\14\6\1\10\130\6\1\10\54\6\1"+
    "\7\35\6\1\11\3\6\1\10\1\6\1\16\4\6\1\10\10\6\1\10\12\6\1\10\3\6\1\10\13\6"+
    "\1\10\3\6\1\7\2\6\1\10\15\6\1\7\32\6\1\10\60\6\1\7\6\6\1\10\143\6\1\17\1\20"+
    "\12\6\1\10\65\6");

  /* The ZZ_CMAP_A table has 544 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\5\1\22\0\1\1\1\53\1\10\1\6\1\11\1\52\1\43\1\7\1\54\1\55\1\51\1\32\1"+
    "\47\1\12\1\14\1\4\1\26\11\27\1\15\1\0\1\57\1\5\1\50\1\33\1\0\4\13\1\31\25"+
    "\13\1\16\1\0\1\56\1\0\1\13\1\0\1\42\1\13\1\37\1\34\1\22\1\25\1\13\1\40\1\24"+
    "\2\13\1\21\1\13\1\20\1\45\2\13\1\41\1\23\1\36\1\17\1\13\1\35\1\46\2\13\1\2"+
    "\1\44\1\3\7\0\1\1\32\0\1\1\77\0\12\30\46\0\12\30\14\0\12\30\20\0\12\30\6\0"+
    "\12\30\6\0\13\1\35\0\2\1\5\0\1\1\57\0\1\1\26\0\12\30\16\0\62\30");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\1\7\0\1\1\1\2\4\3\1\2\1\4\1\5"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\3\1\14"+
    "\1\15\5\12\2\16\1\17\1\20\2\12\2\3\2\12"+
    "\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
    "\1\31\1\32\1\12\1\33\2\16\1\3\1\34\5\3"+
    "\1\35\3\0\1\36\1\37\2\0\1\40\1\41\1\42"+
    "\1\43\1\44\4\12\1\45\1\12\3\0\1\46\1\47"+
    "\1\50\2\12\1\51\2\52\1\12\1\53\1\54\1\55"+
    "\1\56\1\57\1\60\1\0\1\61\7\0\1\62\1\63"+
    "\1\64\1\0\1\65\1\0\1\66\1\67\5\12\1\0"+
    "\1\44\1\12\1\51\1\70\1\71\1\72\1\0\1\73"+
    "\1\0\1\74\1\75\1\0\3\12\1\76\2\12\1\77"+
    "\1\100\1\0\2\12\1\66\2\12\1\101\1\0\1\102"+
    "\1\12\1\103\1\104\1\105\2\12\1\105";

  private static int [] zzUnpackAction() {
    int [] result = new int[158];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\60\0\140\0\220\0\300\0\360\0\u0120\0\u0150"+
    "\0\u0180\0\u01b0\0\u01e0\0\u0210\0\u0240\0\u0270\0\u02a0\0\u0270"+
    "\0\u02d0\0\u0300\0\u0330\0\u0270\0\u0270\0\u0360\0\u0390\0\u03c0"+
    "\0\u0270\0\u0270\0\u03f0\0\u0420\0\u0450\0\u0480\0\u04b0\0\u04e0"+
    "\0\u0510\0\u0540\0\u0570\0\u05a0\0\u05d0\0\u0600\0\u0630\0\u0660"+
    "\0\u0690\0\u0270\0\u06c0\0\u06f0\0\u0720\0\u0750\0\u0270\0\u0270"+
    "\0\u0270\0\u0780\0\u0270\0\u07b0\0\u0270\0\u0270\0\u07e0\0\u0810"+
    "\0\u0270\0\u0840\0\u0870\0\u08a0\0\u08d0\0\u0900\0\u0930\0\u0210"+
    "\0\u0960\0\u0990\0\u0270\0\u0270\0\u09c0\0\u09f0\0\u0a20\0\u0270"+
    "\0\u0270\0\u0270\0\u0a50\0\u0a80\0\u0ab0\0\u0ae0\0\u0b10\0\u0360"+
    "\0\u0b40\0\u03c0\0\u0b70\0\u04e0\0\u0270\0\u0270\0\u0270\0\u0ba0"+
    "\0\u0bd0\0\u0270\0\u0270\0\u0360\0\u0c00\0\u0270\0\u0270\0\u0270"+
    "\0\u0270\0\u0c30\0\u0c60\0\u0810\0\u0270\0\u0840\0\u0870\0\u0c90"+
    "\0\u0cc0\0\u08d0\0\u0cf0\0\u0d20\0\u0270\0\u0270\0\u0270\0\u0d50"+
    "\0\u0270\0\u0d80\0\u0270\0\u0270\0\u0db0\0\u0de0\0\u0e10\0\u0e40"+
    "\0\u0e70\0\u0ea0\0\u0ea0\0\u0ed0\0\u0360\0\u0360\0\u0270\0\u0270"+
    "\0\u0f00\0\u0270\0\u0f30\0\u0270\0\u0270\0\u0f60\0\u0f90\0\u0fc0"+
    "\0\u0ff0\0\u1020\0\u1050\0\u1080\0\u0360\0\u0270\0\u10b0\0\u10e0"+
    "\0\u1110\0\u0360\0\u1140\0\u1170\0\u0360\0\u11a0\0\u0360\0\u11d0"+
    "\0\u0360\0\u0360\0\u0270\0\u1200\0\u1230\0\u0360";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[158];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\11\1\12\1\13\55\11\6\14\1\15\51\14\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\16\1\24\1\25"+
    "\1\26\1\27\1\26\1\30\1\31\1\32\1\33\2\26"+
    "\1\34\1\35\1\36\1\37\1\40\1\41\1\16\1\26"+
    "\1\42\1\43\2\26\1\44\3\26\1\45\1\46\1\47"+
    "\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57"+
    "\1\60\1\61\1\62\7\63\1\24\1\25\1\64\1\63"+
    "\1\64\1\65\1\31\1\32\7\64\1\66\1\67\1\63"+
    "\1\64\2\63\7\64\2\63\2\64\7\63\1\61\1\63"+
    "\7\70\1\71\50\70\10\72\1\71\47\72\11\73\1\74"+
    "\46\73\33\75\1\76\24\75\2\11\1\0\56\11\1\12"+
    "\1\0\55\11\2\0\1\77\55\0\6\100\1\101\54\100"+
    "\1\102\2\100\1\101\51\100\61\0\1\17\61\0\1\103"+
    "\61\0\1\104\11\0\1\105\4\0\1\106\40\0\1\107"+
    "\42\0\1\110\21\0\2\26\3\111\11\26\1\0\1\26"+
    "\2\0\7\26\2\0\2\26\16\0\1\112\100\0\2\113"+
    "\42\0\2\26\3\111\1\26\1\114\7\26\1\0\1\26"+
    "\2\0\7\26\2\0\2\26\23\0\2\26\3\111\1\26"+
    "\1\115\1\116\6\26\1\0\1\26\2\0\7\26\2\0"+
    "\2\26\23\0\2\26\3\111\11\26\1\0\1\26\2\0"+
    "\1\26\1\117\5\26\2\0\2\26\23\0\2\26\3\111"+
    "\6\26\1\120\2\26\1\0\1\26\2\0\7\26\2\0"+
    "\2\26\23\0\2\26\3\111\11\26\1\0\1\26\2\0"+
    "\6\26\1\121\2\0\2\26\25\0\1\122\5\0\1\123"+
    "\3\0\2\124\1\0\1\123\42\0\1\122\5\0\1\123"+
    "\3\0\2\41\1\67\1\123\33\0\1\125\57\0\1\126"+
    "\25\0\1\127\36\0\2\26\3\111\11\26\1\0\1\26"+
    "\2\0\5\26\1\130\1\26\2\0\2\26\23\0\2\26"+
    "\3\111\1\26\1\131\7\26\1\0\1\26\2\0\7\26"+
    "\2\0\2\26\54\0\1\132\60\0\1\133\25\0\2\26"+
    "\3\111\11\26\1\0\1\26\2\0\5\26\1\134\1\26"+
    "\2\0\2\26\23\0\2\26\3\111\11\26\1\0\1\26"+
    "\2\0\7\26\2\0\1\135\1\26\16\0\1\136\57\0"+
    "\1\137\43\0\1\140\13\0\1\141\57\0\1\142\57\0"+
    "\1\143\64\0\2\64\3\0\11\64\1\0\1\64\2\0"+
    "\7\64\2\0\2\64\37\0\3\67\27\0\7\144\1\145"+
    "\50\144\10\146\1\145\47\146\11\147\1\150\51\147\1\151"+
    "\5\147\1\150\46\147\33\152\1\153\27\152\1\154\27\152"+
    "\1\153\24\152\6\0\1\155\2\0\1\156\21\0\1\157"+
    "\24\0\3\100\1\160\2\100\1\101\54\100\1\161\2\100"+
    "\1\101\51\100\20\0\1\162\64\0\1\163\37\0\1\164"+
    "\74\0\1\123\3\0\2\113\1\0\1\123\40\0\2\26"+
    "\3\111\2\26\1\165\6\26\1\0\1\26\2\0\7\26"+
    "\2\0\2\26\23\0\2\26\3\111\11\26\1\0\1\26"+
    "\2\0\1\166\6\26\2\0\2\26\23\0\2\26\3\111"+
    "\4\26\1\167\4\26\1\0\1\26\2\0\7\26\2\0"+
    "\2\26\23\0\2\26\3\111\5\26\1\170\3\26\1\0"+
    "\1\26\2\0\7\26\2\0\2\26\23\0\2\26\3\111"+
    "\2\26\1\171\6\26\1\0\1\26\2\0\7\26\2\0"+
    "\2\26\23\0\1\172\13\0\2\173\2\0\1\172\37\0"+
    "\2\26\3\111\1\174\10\26\1\0\1\26\2\0\7\26"+
    "\2\0\2\26\23\0\2\26\3\111\11\26\1\0\1\26"+
    "\2\0\1\175\6\26\2\0\2\26\23\0\2\26\3\111"+
    "\11\26\1\0\1\26\2\0\5\26\1\176\1\26\2\0"+
    "\2\26\16\0\1\177\122\0\1\200\7\0\3\147\1\201"+
    "\5\147\1\150\51\147\1\202\5\147\1\150\46\147\3\152"+
    "\1\203\27\152\1\153\27\152\1\204\27\152\1\153\24\152"+
    "\3\100\1\205\2\100\1\101\51\100\21\0\1\206\50\0"+
    "\2\26\3\111\3\26\1\207\5\26\1\0\1\26\2\0"+
    "\7\26\2\0\2\26\23\0\2\26\3\111\1\210\4\26"+
    "\1\211\3\26\1\0\1\26\2\0\7\26\2\0\2\26"+
    "\23\0\2\26\3\111\3\26\1\212\5\26\1\0\1\26"+
    "\2\0\7\26\2\0\2\26\23\0\2\26\3\111\11\26"+
    "\1\0\1\26\2\0\2\26\1\213\4\26\2\0\2\26"+
    "\23\0\2\26\3\111\4\26\1\214\4\26\1\0\1\26"+
    "\2\0\7\26\2\0\2\26\37\0\2\173\42\0\2\26"+
    "\3\111\3\26\1\215\5\26\1\0\1\26\2\0\7\26"+
    "\2\0\2\26\11\0\3\147\1\216\5\147\1\150\46\147"+
    "\3\152\1\216\27\152\1\153\24\152\22\0\1\217\47\0"+
    "\2\26\3\111\4\26\1\220\4\26\1\0\1\26\2\0"+
    "\7\26\2\0\2\26\23\0\2\26\3\111\1\26\1\221"+
    "\7\26\1\0\1\26\2\0\7\26\2\0\2\26\23\0"+
    "\2\26\3\111\6\26\1\222\2\26\1\0\1\26\2\0"+
    "\7\26\2\0\2\26\23\0\2\26\3\111\5\26\1\223"+
    "\3\26\1\0\1\26\2\0\7\26\2\0\2\26\23\0"+
    "\2\26\3\111\11\26\1\0\1\26\2\0\3\26\1\224"+
    "\3\26\2\0\2\26\23\0\2\26\3\111\3\26\1\225"+
    "\5\26\1\0\1\26\2\0\7\26\2\0\2\26\34\0"+
    "\1\226\46\0\2\26\3\111\4\26\1\227\4\26\1\0"+
    "\1\26\2\0\7\26\2\0\2\26\23\0\2\26\3\111"+
    "\2\26\1\230\6\26\1\0\1\26\2\0\7\26\2\0"+
    "\2\26\23\0\2\26\3\111\6\26\1\231\2\26\1\0"+
    "\1\26\2\0\7\26\2\0\2\26\23\0\2\26\3\111"+
    "\11\26\1\0\1\26\2\0\4\26\1\232\2\26\2\0"+
    "\2\26\34\0\1\233\46\0\2\26\3\111\3\26\1\234"+
    "\5\26\1\0\1\26\2\0\7\26\2\0\2\26\23\0"+
    "\2\26\3\111\4\26\1\235\4\26\1\0\1\26\2\0"+
    "\7\26\2\0\2\26\23\0\2\26\3\111\4\26\1\236"+
    "\4\26\1\0\1\26\2\0\7\26\2\0\2\26\11\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4704];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\1\7\0\5\1\1\11\1\1\1\11\3\1\2\11"+
    "\3\1\2\11\17\1\1\11\4\1\3\11\1\1\1\11"+
    "\1\1\2\11\2\1\1\11\6\1\3\0\2\11\2\0"+
    "\1\1\3\11\7\1\3\0\3\11\2\1\2\11\2\1"+
    "\4\11\2\1\1\0\1\11\7\0\3\11\1\0\1\11"+
    "\1\0\2\11\5\1\1\0\4\1\2\11\1\0\1\11"+
    "\1\0\2\11\1\0\7\1\1\11\1\0\6\1\1\0"+
    "\4\1\1\11\3\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[158];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    private final Deque<Integer> lexStateStack = new ArrayDeque<Integer>();

    public AntlersLexer() {
        this((java.io.Reader)null);
    }

    private void pushState(int state) {
      lexStateStack.push(yystate());
      yybegin(state);
    }

    private void popState() {
      if (lexStateStack.isEmpty()) {
          yybegin(YYINITIAL);
      } else {
          yybegin(lexStateStack.pop());
      }
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public AntlersLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return OUTER_CONTENT;
            } 
            // fall through
          case 70: break;
          case 2: 
            { return WHITE_SPACE;
            } 
            // fall through
          case 71: break;
          case 3: 
            { yybegin(YYINITIAL); return OUTER_CONTENT;
            } 
            // fall through
          case 72: break;
          case 4: 
            { return T_LEFT_BRACE;
            } 
            // fall through
          case 73: break;
          case 5: 
            { return T_RIGHT_BRACE;
            } 
            // fall through
          case 74: break;
          case 6: 
            { return T_SLASH;
            } 
            // fall through
          case 75: break;
          case 7: 
            { return T_OP_ASSIGN;
            } 
            // fall through
          case 76: break;
          case 8: 
            { pushState(SINGLE_STRING); return T_STRING_START;
            } 
            // fall through
          case 77: break;
          case 9: 
            { pushState(DOUBLE_STRING); return T_STRING_START;
            } 
            // fall through
          case 78: break;
          case 10: 
            { return T_IDENTIFIER;
            } 
            // fall through
          case 79: break;
          case 11: 
            { return T_OP_MINUS;
            } 
            // fall through
          case 80: break;
          case 12: 
            { return T_COLON;
            } 
            // fall through
          case 81: break;
          case 13: 
            { return T_LEFT_BRACKET;
            } 
            // fall through
          case 82: break;
          case 14: 
            { return T_INTEGER_NUMBER;
            } 
            // fall through
          case 83: break;
          case 15: 
            { return T_OP_PLUS;
            } 
            // fall through
          case 84: break;
          case 16: 
            { return T_OP_QUESTIONMARK;
            } 
            // fall through
          case 85: break;
          case 17: 
            { return T_COMMA;
            } 
            // fall through
          case 86: break;
          case 18: 
            { return T_OP_GT;
            } 
            // fall through
          case 87: break;
          case 19: 
            { return T_OP_MUL;
            } 
            // fall through
          case 88: break;
          case 20: 
            { return T_OP_MOD;
            } 
            // fall through
          case 89: break;
          case 21: 
            { return T_OP_EXCLAMATION_MARK;
            } 
            // fall through
          case 90: break;
          case 22: 
            { return T_LP;
            } 
            // fall through
          case 91: break;
          case 23: 
            { return T_RP;
            } 
            // fall through
          case 92: break;
          case 24: 
            { return T_RIGHT_BRACKET;
            } 
            // fall through
          case 93: break;
          case 25: 
            { return T_OP_LT;
            } 
            // fall through
          case 94: break;
          case 26: 
            { yypushback(1);  // cancel unexpected char
                                  popState();     // and try to parse it again in <IN_ANTLERS>
            } 
            // fall through
          case 95: break;
          case 27: 
            { return T_DOT;
            } 
            // fall through
          case 96: break;
          case 28: 
            { popState(); return T_STRING_END;
            } 
            // fall through
          case 97: break;
          case 29: 
            { pushState(ANTLERS_NODE); return T_LD;
            } 
            // fall through
          case 98: break;
          case 30: 
            { popState(); return T_RD;
            } 
            // fall through
          case 99: break;
          case 31: 
            { return T_OP_SELF_ASSIGN_DIV;
            } 
            // fall through
          case 100: break;
          case 32: 
            { return T_OP_EQ;
            } 
            // fall through
          case 101: break;
          case 33: 
            { return T_OP_ARROW;
            } 
            // fall through
          case 102: break;
          case 34: 
            { yypushback(yylength()); pushState(PROPERTY_ACCESS);
            } 
            // fall through
          case 103: break;
          case 35: 
            { return T_OP_SELF_ASSIGN_SUB;
            } 
            // fall through
          case 104: break;
          case 36: 
            { return T_FLOAT_NUMBER;
            } 
            // fall through
          case 105: break;
          case 37: 
            { return T_IF;
            } 
            // fall through
          case 106: break;
          case 38: 
            { return T_OP_SELF_ASSIGN_ADD;
            } 
            // fall through
          case 107: break;
          case 39: 
            { return T_OP_GATEKEEPER;
            } 
            // fall through
          case 108: break;
          case 40: 
            { return T_OP_NULL_COALESCENCE;
            } 
            // fall through
          case 109: break;
          case 41: 
            { return T_OP_AND;
            } 
            // fall through
          case 110: break;
          case 42: 
            { return T_OP_OR;
            } 
            // fall through
          case 111: break;
          case 43: 
            { return T_OP_GTE;
            } 
            // fall through
          case 112: break;
          case 44: 
            { return T_OP_SELF_ASSIGN_MUL;
            } 
            // fall through
          case 113: break;
          case 45: 
            { return T_OP_POW;
            } 
            // fall through
          case 114: break;
          case 46: 
            { return T_OP_SELF_ASSIGN_MOD;
            } 
            // fall through
          case 115: break;
          case 47: 
            { return T_OP_NEQ;
            } 
            // fall through
          case 116: break;
          case 48: 
            { return T_OP_LTE;
            } 
            // fall through
          case 117: break;
          case 49: 
            { yypushback(1); return T_STRING_CONTENT;
            } 
            // fall through
          case 118: break;
          case 50: 
            { yypushback(yylength() - 3); pushState(ANTLERS_COMMENT); return T_COMMENT_OPEN;
            } 
            // fall through
          case 119: break;
          case 51: 
            { pushState(PHP_ECHO); return T_PHP_ECHO_OPEN;
            } 
            // fall through
          case 120: break;
          case 52: 
            { pushState(PHP_RAW); return T_PHP_RAW_OPEN;
            } 
            // fall through
          case 121: break;
          case 53: 
            { popState(); return T_COMMENT_CLOSE;
            } 
            // fall through
          case 122: break;
          case 54: 
            { return T_END_IF;
            } 
            // fall through
          case 123: break;
          case 55: 
            { return T_OP_IDENT;
            } 
            // fall through
          case 124: break;
          case 56: 
            { return T_OP_XOR;
            } 
            // fall through
          case 125: break;
          case 57: 
            { return T_OP_NOT_IDENT;
            } 
            // fall through
          case 126: break;
          case 58: 
            { return T_OP_SPACESHIP;
            } 
            // fall through
          case 127: break;
          case 59: 
            { popState(); return T_PHP_ECHO_CLOSE;
            } 
            // fall through
          case 128: break;
          case 60: 
            { popState(); return T_PHP_RAW_CLOSE;
            } 
            // fall through
          case 129: break;
          case 61: 
            { yypushback(3); return T_COMMENT_TEXT;
            } 
            // fall through
          case 130: break;
          case 62: 
            { return T_ELSE;
            } 
            // fall through
          case 131: break;
          case 63: 
            { return T_TRUE;
            } 
            // fall through
          case 132: break;
          case 64: 
            { yypushback(3); return T_PHP_CONTENT;
            } 
            // fall through
          case 133: break;
          case 65: 
            { return T_FALSE;
            } 
            // fall through
          case 134: break;
          case 66: 
            { return T_UNLESS;
            } 
            // fall through
          case 135: break;
          case 67: 
            { return T_ELSE_IF;
            } 
            // fall through
          case 136: break;
          case 68: 
            { return T_SWITCH;
            } 
            // fall through
          case 137: break;
          case 69: 
            { return T_END_UNLESS;
            } 
            // fall through
          case 138: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
