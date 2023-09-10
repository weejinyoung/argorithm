import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ReceivingReportResults {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reporterMap = new HashMap<>();
        Map<String, Integer> reporteeMap = new HashMap<>();
        Map<String, Integer> answerMap = new HashMap<>();
        int[] answer = new int[id_list.length];

        // 초기화
        for (String id : id_list) {
            reporterMap.put(id, new HashSet<>());
            reporteeMap.put(id, 0);
            answerMap.put(id, 0);
        }

        // 사용자가 신고한 사용자들 저장
        for (String reportElement : report) {
            String[] reportElementSplit = reportElement.split(" ");
            reporterMap.get(reportElementSplit[0]).add(reportElementSplit[1]);
        }

        // 사용자가 신고를 당한 횟수 저장
        reporterMap.forEach((reporter, reporteeSet) -> {
            for (String reportee : reporteeSet) {
                int reportedCnt = reporteeMap.get(reportee);
                reporteeMap.replace(reportee, reportedCnt + 1);
            }
        });

        // 정지 기준이 되는 신고횟수가 넘은 사용자를 신고했던 사용자에게 메일 보내기
        reporteeMap.forEach((reportee, reportedCnt) -> {
            if (reportedCnt >= k) {
                reporterMap.forEach((reporter, reporteeSet) -> {
                    if (reporteeSet.contains(reportee)) {
                        int mailCnt = answerMap.get(reporter);
                        answerMap.replace(reporter, mailCnt + 1);
                    }
                });
            }
        });

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = answerMap.get(id_list[i]);
        }

        return answer;

    }
}
