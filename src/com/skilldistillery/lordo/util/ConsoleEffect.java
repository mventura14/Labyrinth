package com.skilldistillery.lordo.util;

public interface ConsoleEffect {

//	Text Format:
	public static final String reset = "\u001B[0m";
	public static final String bold = "\u001B[1m";
	public static final String underline = "\u001B[4m";

//	Text Colors:
	public static final String black = "\u001B[30m";
	public static final String red = "\u001B[31m";
	public static final String green = "\u001B[32m";
	public static final String yellow = "\u001B[33m";
	public static final String blue = "\u001B[34m";
	public static final String magenta = " \u001B[35m";
	public static final String cyan = "\u001B[36m";
	public static final String white = "\u001B[37m";

//	Bright Text Colors:
	public static final String bblack = "\u001B[90m";
	public static final String bred = "\u001B[91m";
	public static final String bgreen = "\u001B[92m";
	public static final String byellow = "\u001B[93m";
	public static final String bblue = "\u001B[94m";
	public static final String bmagenta = "\u001B[95m";
	public static final String bcyan = "\u001B[96m";
	public static final String bwhite = "\u001B[97m";

//	Background colors
	public static final String blackBg = "\u001B[40m";
	public static final String redBg = "\u001B[41m";
	public static final String greenBg = "\u001B[42m";
	public static final String yellowBg = "\u001B[43m";
	public static final String blueBg = "\u001B[44m";
	public static final String magentaBg = "\u001B[45m";
	public static final String cyanBg = "\u001B[46m";
	public static final String whiteBg = "\u001B[47m";

//	Bright Background colors
	public static final String bblackBg = "\u001B[100m";
	public static final String bredBg = "\u001B[101m";
	public static final String bgreenBg = "\u001B[102m";
	public static final String byellowBg = "\u001B[103m";
	public static final String bblueBg = "\u001B[104m";
	public static final String bmagentaBg = "\u001B[105m";
	public static final String bcyanBg = "\u001B[106m";
	public static final String bwhiteBg = "\u001B[107m";



}