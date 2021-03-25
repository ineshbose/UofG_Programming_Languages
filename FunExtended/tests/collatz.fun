# Test switch statements.

bool a = true
bool b = false

int c = 1
int d = 2

func int modulo (int dividend, int divisor):
    return dividend - (divisor * (dividend / divisor))
.

func int plusOddMinusEven (int base, int new):
    int result = 0
    switch modulo(new, 2):
        case 1:
            result = base + new
        case 0:
            result = base - new
        default:
    .
    return result
.

func int combine (int maximum):
    int total = 0
    int counter = 0
    switch maximum:
        case 0:
            total = 0 - 1
        case 1..7:
        case 8..99:
            for counter = 3 to maximum:
                total = plusOddMinusEven(total, counter)
            .
        default:
            total = 100
    .
    return total
.

func int collatz (int n):
    int counter = 0
    while n > 1:
        switch modulo(n, 2):
            case 0:
                n = n / 2
            default:
                n = (3 * n) + 1
        .
        counter = counter + 1
    .
    return counter
.

proc main ():
    int e = 3
    int f = 4

    int reallyBigSwitch = 15
    switch reallyBigSwitch:
        case 1..3:
            write(1)
        case 4..14:
            e = combine(e)
        case 15:
            switch combine((e * f) + 1):
                case 8:
                    write(0)
                default:
                    write(2)
            .
            if a:
                switch combine((e * e * f) + 1):
                    case 20:
                        write(0)
                    default:
                        write(3)
                .
            .
            switch b:
                case true:
                    c = combine(6)
                    write(4)
                default:
                    c = combine(6)
                    switch c:
                        case 0:
                            write(0)
                        default:
                            write(4)
                    .
            .
            switch collatz(43):
                case 30:
                    write(5)
                case 29:
                    switch collatz(29):
                        case 0:
                            write(6)
                        case 18:
                            write(0)
                        default:
                            write(7)
                    .
                case 28:
                    write(8)
                case 31..40:
                    write(9)
                default:
                    write(10)
            .
        case 16..18:
            write(11)
        default:
            write(12)
    .
.