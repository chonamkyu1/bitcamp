package Exam0806;

import java.util.ArrayList;
import java.util.List;

public class StudentManagerImpl implements StudentManager {
	List<StudentVO> list = new ArrayList<>();

	@Override
	public int insert(StudentVO vo) {

		if (contains(vo.getId()))
			return 0;
		if (list.add(vo))
			return 1;
		return 0;
	}

	public boolean contains(String id) {
		for (StudentVO student : list) {
			if (student.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public StudentVO selectOne(String id) {
		List<StudentVO> vo = new ArrayList<>();
		for (StudentVO student : list) {
			if (student.getId().equals(id)) {
				return student;
			}
		}
		return null;
	}

	@Override
	public List<StudentVO> selectList(String name) {
		List<StudentVO> vo = new ArrayList<>();
		for (StudentVO student : list) {
			if (student.getName().equals(name)) {
				vo.add(student);
			}

		}
		return vo;
	}

	@Override
	public List<StudentVO> selectAll() {
		List<StudentVO> vo = new ArrayList<>();
		for (StudentVO student : list) {
			vo.add(student);
		}

		return vo;
	}

	@Override
	public int update(StudentVO vo) {
		String id = vo.getId();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				list.set(i, vo);
				list.get(i).computeTotAvg();
				return 1;
			}
		}

		return 0;
	}

	@Override
	public int delete(String id) {
		List<StudentVO> vo = new ArrayList<>();
		for (StudentVO student : list) {
			if (!student.getId().equals(id)) {
				vo.add(student);
			}
		}
		list = vo;
		return 1;
	}

}
