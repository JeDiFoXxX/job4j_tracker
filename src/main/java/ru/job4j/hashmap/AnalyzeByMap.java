package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double score = 0D;
        int subjects = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                subjects++;
            }
        }
        return score / subjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0D;
            int subjects = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                subjects++;
            }
            list.add(new Label(pupil.name(), score / subjects));
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        Map<String, Double[]> maps = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                maps.putIfAbsent(subject.name(), new Double[]{0D, 0D});
                Double[] scoreSubjects = maps.get(subject.name());
                scoreSubjects[0] += subject.score();
                scoreSubjects[1]++;
            }
        }

        for (String key : maps.keySet()) {
            Double[] scoreSubject = maps.get(key);
            list.add(new Label(key, scoreSubject[0] / scoreSubject[1]));
        }
        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0D;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            list.add(new Label(pupil.name(), score));
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        Map<String, Double> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.putIfAbsent(subject.name(), 0D);
                map.put(subject.name(), map.get(subject.name()) + subject.score());
            }
        }

        for (String key : map.keySet()) {
            list.add(new Label(key, map.get(key)));
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }
}
