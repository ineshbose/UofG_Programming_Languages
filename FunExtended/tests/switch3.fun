# Test switch-commands.

proc main ():
    int s = 9
    switch s:
        case 1:
            s = 9
        case 2..4:
            s = 5
        default:
            s = 1
    .
    write(s)
.
