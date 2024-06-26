// Generated from src/ast/Calc.g4 by ANTLR 4.9.1

	package ast;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalcLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PUT=1, SET=2, ASSN=3, PLUS=4, MINUS=5, TIMES=6, DIV=7, LPAR=8, RPAR=9, 
		ID=10, NUM=11, EOL=12, SPACE=13, SCOMMENT=14, MCOMMENT=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PUT", "SET", "ASSN", "PLUS", "MINUS", "TIMES", "DIV", "LPAR", "RPAR", 
			"ID", "NUM", "EOL", "SPACE", "SCOMMENT", "MCOMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'put'", "'set'", "'='", "'+'", "'-'", "'*'", "'/'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PUT", "SET", "ASSN", "PLUS", "MINUS", "TIMES", "DIV", "LPAR", 
			"RPAR", "ID", "NUM", "EOL", "SPACE", "SCOMMENT", "MCOMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public CalcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21f\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\6\139\n\13\r\13\16\13:\3\f\6\f>\n\f\r\f\16\f?\3\r\5\rC\n\r\3\r\3\r"+
		"\3\16\6\16H\n\16\r\16\16\16I\3\16\3\16\3\17\3\17\3\17\3\17\7\17R\n\17"+
		"\f\17\16\17U\13\17\3\17\3\17\3\20\3\20\3\20\3\20\7\20]\n\20\f\20\16\20"+
		"`\13\20\3\20\3\20\3\20\3\20\3\20\3^\2\21\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21\3\2\4\4\2\13\13\"\"\4\2"+
		"\f\f\17\17\2k\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3!\3\2"+
		"\2\2\5%\3\2\2\2\7)\3\2\2\2\t+\3\2\2\2\13-\3\2\2\2\r/\3\2\2\2\17\61\3\2"+
		"\2\2\21\63\3\2\2\2\23\65\3\2\2\2\258\3\2\2\2\27=\3\2\2\2\31B\3\2\2\2\33"+
		"G\3\2\2\2\35M\3\2\2\2\37X\3\2\2\2!\"\7r\2\2\"#\7w\2\2#$\7v\2\2$\4\3\2"+
		"\2\2%&\7u\2\2&\'\7g\2\2\'(\7v\2\2(\6\3\2\2\2)*\7?\2\2*\b\3\2\2\2+,\7-"+
		"\2\2,\n\3\2\2\2-.\7/\2\2.\f\3\2\2\2/\60\7,\2\2\60\16\3\2\2\2\61\62\7\61"+
		"\2\2\62\20\3\2\2\2\63\64\7*\2\2\64\22\3\2\2\2\65\66\7+\2\2\66\24\3\2\2"+
		"\2\679\4c|\28\67\3\2\2\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\26\3\2\2\2<>\4"+
		"\62;\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\30\3\2\2\2AC\7\17\2\2"+
		"BA\3\2\2\2BC\3\2\2\2CD\3\2\2\2DE\7\f\2\2E\32\3\2\2\2FH\t\2\2\2GF\3\2\2"+
		"\2HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\b\16\2\2L\34\3\2\2\2MN\7"+
		"\61\2\2NO\7\61\2\2OS\3\2\2\2PR\n\3\2\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2S"+
		"T\3\2\2\2TV\3\2\2\2US\3\2\2\2VW\b\17\2\2W\36\3\2\2\2XY\7\61\2\2YZ\7,\2"+
		"\2Z^\3\2\2\2[]\13\2\2\2\\[\3\2\2\2]`\3\2\2\2^_\3\2\2\2^\\\3\2\2\2_a\3"+
		"\2\2\2`^\3\2\2\2ab\7,\2\2bc\7\61\2\2cd\3\2\2\2de\b\20\2\2e \3\2\2\2\t"+
		"\2:?BIS^\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}