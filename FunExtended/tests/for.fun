# Test for-commands.

func int fac (int n):
    int i = 0
    int f = 1
    for i = 2 to n:
        f = f*i .
    return f
.

proc main ():
	write(fac(5))
.
