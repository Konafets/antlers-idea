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
  public static final int SINGLE_STRING = 6;
  public static final int DOUBLE_STRING = 8;
  public static final int PHP_ECHO = 10;
  public static final int PHP_RAW = 12;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6, 6
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
    "\11\0\5\1\22\0\1\1\1\0\1\6\1\4\1\7\2\0\1\5\1\31\1\32\1\0\1\17\1\0\1\10\1\15"+
    "\1\0\1\12\11\13\3\0\1\33\1\0\1\20\1\0\4\11\1\16\25\11\4\0\1\11\1\0\1\26\3"+
    "\11\1\24\1\25\5\11\1\27\5\11\1\22\1\30\1\21\1\23\5\11\1\2\1\0\1\3\7\0\1\1"+
    "\32\0\1\1\77\0\12\14\46\0\12\14\14\0\12\14\20\0\12\14\6\0\12\14\6\0\13\1\35"+
    "\0\2\1\5\0\1\1\57\0\1\1\26\0\12\14\16\0\62\14");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\1\6\0\1\1\1\2\4\3\1\2\1\4\1\5"+
    "\1\6\1\7\1\10\2\11\1\3\2\10\1\12\1\13"+
    "\1\14\1\3\1\15\5\3\1\16\3\0\1\17\3\0"+
    "\1\11\1\20\2\10\1\0\1\21\7\0\1\22\1\23"+
    "\1\24\1\0\1\25\1\0\1\20\2\10\1\0\1\26"+
    "\1\0\1\27\1\30\1\31\1\10\1\32\1\33";

  private static int [] zzUnpackAction() {
    int [] result = new int[73];
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
    "\0\0\0\34\0\70\0\124\0\160\0\214\0\250\0\304"+
    "\0\340\0\374\0\u0118\0\u0134\0\u0150\0\u016c\0\u0150\0\u0188"+
    "\0\u0150\0\u0150\0\u01a4\0\u01c0\0\u01dc\0\u01f8\0\u0214\0\u0230"+
    "\0\u0150\0\u0150\0\u0150\0\u024c\0\u0150\0\u0268\0\u0284\0\u02a0"+
    "\0\u02bc\0\u02d8\0\u02f4\0\u0118\0\u0310\0\u032c\0\u0150\0\u01c0"+
    "\0\u01f8\0\u0348\0\u0364\0\u0380\0\u039c\0\u03b8\0\u024c\0\u0150"+
    "\0\u0268\0\u0284\0\u03d4\0\u03f0\0\u02bc\0\u040c\0\u0428\0\u0150"+
    "\0\u0150\0\u0150\0\u0444\0\u0150\0\u0460\0\u0460\0\u047c\0\u0498"+
    "\0\u04b4\0\u0150\0\u04d0\0\u0150\0\u0150\0\u01a4\0\u04ec\0\u0150"+
    "\0\u01a4";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[73];
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
    "\1\10\1\11\1\12\31\10\4\13\1\14\27\13\1\15"+
    "\1\16\1\17\1\20\1\15\1\21\1\22\1\23\1\15"+
    "\1\23\1\24\1\25\1\15\1\26\1\23\2\15\1\27"+
    "\3\23\1\30\3\23\1\31\1\32\1\33\5\34\1\35"+
    "\26\34\6\36\1\35\25\36\7\37\1\40\24\37\20\41"+
    "\1\42\13\41\2\10\1\0\32\10\1\11\1\0\31\10"+
    "\2\0\1\43\31\0\4\44\1\45\32\44\1\46\1\45"+
    "\27\44\35\0\1\16\35\0\1\47\40\0\4\23\2\0"+
    "\1\23\2\0\10\23\15\0\2\50\1\0\1\51\1\52"+
    "\5\0\1\52\21\0\2\25\1\53\1\51\1\52\5\0"+
    "\1\52\21\0\2\54\30\0\4\23\2\0\1\23\2\0"+
    "\1\23\1\55\6\23\13\0\4\23\2\0\1\23\2\0"+
    "\5\23\1\56\2\23\3\0\5\57\1\60\26\57\6\61"+
    "\1\60\25\61\7\62\1\63\27\62\1\64\3\62\1\63"+
    "\24\62\20\65\1\66\16\65\1\67\14\65\1\66\13\65"+
    "\4\0\1\70\2\0\1\71\10\0\1\72\13\0\3\44"+
    "\1\73\1\45\32\44\1\74\1\45\27\44\10\0\1\75"+
    "\1\0\2\76\3\0\1\75\26\0\3\53\31\0\2\54"+
    "\2\0\1\52\5\0\1\52\17\0\4\23\2\0\1\23"+
    "\2\0\2\23\1\77\5\23\13\0\4\23\2\0\1\23"+
    "\2\0\6\23\1\100\1\23\3\0\3\62\1\101\3\62"+
    "\1\63\27\62\1\102\3\62\1\63\24\62\3\65\1\103"+
    "\14\65\1\66\16\65\1\104\14\65\1\66\13\65\3\44"+
    "\1\105\1\45\27\44\12\0\2\76\30\0\4\23\2\0"+
    "\1\23\2\0\3\23\1\106\4\23\13\0\4\23\2\0"+
    "\1\23\2\0\7\23\1\107\3\0\3\62\1\110\3\62"+
    "\1\63\24\62\3\65\1\110\14\65\1\66\13\65\10\0"+
    "\4\23\2\0\1\23\2\0\3\23\1\111\4\23\3\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1288];
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
    "\1\1\6\0\5\1\1\11\1\1\1\11\1\1\2\11"+
    "\6\1\3\11\1\1\1\11\6\1\3\0\1\11\3\0"+
    "\4\1\1\0\1\11\7\0\3\11\1\0\1\11\1\0"+
    "\3\1\1\0\1\11\1\0\2\11\2\1\1\11\1\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[73];
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
          case 28: break;
          case 2: 
            { return WHITE_SPACE;
            } 
            // fall through
          case 29: break;
          case 3: 
            { yybegin(YYINITIAL); return OUTER_CONTENT;
            } 
            // fall through
          case 30: break;
          case 4: 
            { return T_LEFT_BRACE;
            } 
            // fall through
          case 31: break;
          case 5: 
            { return T_RIGHT_BRACE;
            } 
            // fall through
          case 32: break;
          case 6: 
            { pushState(SINGLE_STRING); return T_STRING_START;
            } 
            // fall through
          case 33: break;
          case 7: 
            { pushState(DOUBLE_STRING); return T_STRING_START;
            } 
            // fall through
          case 34: break;
          case 8: 
            { return T_IDENTIFIER;
            } 
            // fall through
          case 35: break;
          case 9: 
            { return T_INTEGER_NUMBER;
            } 
            // fall through
          case 36: break;
          case 10: 
            { return T_LP;
            } 
            // fall through
          case 37: break;
          case 11: 
            { return T_RP;
            } 
            // fall through
          case 38: break;
          case 12: 
            { return T_OP_ASSIGN;
            } 
            // fall through
          case 39: break;
          case 13: 
            { popState(); return T_STRING_END;
            } 
            // fall through
          case 40: break;
          case 14: 
            { pushState(ANTLERS_NODE); return T_LD;
            } 
            // fall through
          case 41: break;
          case 15: 
            { popState(); return T_RD;
            } 
            // fall through
          case 42: break;
          case 16: 
            { return T_FLOAT_NUMBER;
            } 
            // fall through
          case 43: break;
          case 17: 
            { yypushback(1); return T_STRING_CONTENT;
            } 
            // fall through
          case 44: break;
          case 18: 
            { yypushback(yylength() - 3); pushState(ANTLERS_COMMENT); return T_COMMENT_OPEN;
            } 
            // fall through
          case 45: break;
          case 19: 
            { pushState(PHP_ECHO); return T_PHP_ECHO_OPEN;
            } 
            // fall through
          case 46: break;
          case 20: 
            { pushState(PHP_RAW); return T_PHP_RAW_OPEN;
            } 
            // fall through
          case 47: break;
          case 21: 
            { popState(); return T_COMMENT_CLOSE;
            } 
            // fall through
          case 48: break;
          case 22: 
            { popState(); return T_PHP_ECHO_CLOSE;
            } 
            // fall through
          case 49: break;
          case 23: 
            { popState(); return T_PHP_RAW_CLOSE;
            } 
            // fall through
          case 50: break;
          case 24: 
            { yypushback(3); return T_COMMENT_TEXT;
            } 
            // fall through
          case 51: break;
          case 25: 
            { return T_TRUE;
            } 
            // fall through
          case 52: break;
          case 26: 
            { yypushback(3); return T_PHP_CONTENT;
            } 
            // fall through
          case 53: break;
          case 27: 
            { return T_FALSE;
            } 
            // fall through
          case 54: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
