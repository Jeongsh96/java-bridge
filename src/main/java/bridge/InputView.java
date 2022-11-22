package bridge;

import camp.nextstep.edu.missionutils.Console;


// TODO 입력 예외 처리를 여기서 할까 밖에서 할까?

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {

        System.out.println("다리의 길이를 입력해주세요.");

        String bridgeLengthInput = Console.readLine();
        if (!bridgeLengthInput.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
        int bridgeLength = Integer.parseInt(bridgeLengthInput);

        if (bridgeLength < 3 && bridgeLength > 20) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3이상 20이하로만 설정 가능합니다.");
        }

        return bridgeLength;
    }

    public int readBridgeSizeWithValidityCheck() {
        int bridgeLength;
        while (true) {
            try {
                bridgeLength = readBridgeSize();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bridgeLength;
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String nextStepInput;
        nextStepInput = Console.readLine();
        if (!nextStepInput.equals("U") || !nextStepInput.equals("D")) {
            throw new IllegalArgumentException("[ERROR] U 혹은 D만 입력 가능합니다.");
        }
        if (nextStepInput.length() > 1) {
            throw new IllegalArgumentException("[ERROR] 한자리만 입력 가능합니다.");
        }
        return nextStepInput;
    }

    public String readMovingWithValidityCheck() {
        String nextStepInput;
        while (true) {
            try {
                nextStepInput=readMoving();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return nextStepInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("재시도 하시겠습니까?");
        String askRetry;
        askRetry = Console.readLine();

        return askRetry;
    }


}
