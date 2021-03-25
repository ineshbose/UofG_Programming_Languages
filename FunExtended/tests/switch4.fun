# Test switch-commands.

func int test (int n):
    int r = 0
    int s = 0
    switch n:
        case 1:
            r = 1
            s = 2
        case 2..4:
            s = 3
        default:
            r = 4
    .
    write(s)
    return r
.

func bool invert (bool b):
    bool x = false
    switch b:
        case true:
            x = false
        default:
            x = true
    .
    return x
.

proc main ():
    write(test(1))
    write(test(3))
    write(test(5))
	if invert(true):
        write(0)
    else:
        write(1)
    .
    if invert(false):
        write(1)
    else:
        write(0)
    .
.
