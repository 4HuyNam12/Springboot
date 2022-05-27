package vn.cmcglobal.ebook.service;

import vn.cmcglobal.ebook.entity.Ebook;

import java.util.List;

public interface StatisticService {
    List<Ebook> findTop10BySold();
}
