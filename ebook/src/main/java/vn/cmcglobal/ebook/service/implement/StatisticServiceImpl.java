package vn.cmcglobal.ebook.service.implement;

import org.springframework.stereotype.Service;
import vn.cmcglobal.ebook.entity.Ebook;
import vn.cmcglobal.ebook.service.StatisticService;

import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {
    @Override
    public List<Ebook> findTop10BySold() {
        return null;
    }
}
