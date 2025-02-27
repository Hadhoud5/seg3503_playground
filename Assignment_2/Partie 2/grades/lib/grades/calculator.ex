defmodule Grades.Calculator do
  def percentage_grade(%{homework: homework, labs: labs, midterm: midterm, final: final}) do
    avg_homework = avg(homework)

    avg_labs = avg(labs)

    mark = calculate_grade(avg_labs, avg_homework, midterm, final)
    round(mark * 100)
  end

  def letter_grade(%{homework: homework, labs: labs, midterm: midterm, final: final}) do
    avg_homework = avg(homework)

    avg_labs = avg(labs)

    avg_exams = (midterm + final) / 2

    num_labs = lab_participation(labs)
  

    if failed_to_participate?(avg_homework, avg_exams, num_labs) do
      "EIN"
    else
      mark = calculate_grade(avg_labs, avg_homework, midterm, final)

     calculate_grade(false, mark)
    end
  end

  def numeric_grade(%{homework: homework, labs: labs, midterm: midterm, final: final}) do
    avg_homework = avg(homework)
     

    avg_labs = avg(labs)
      
    avg_exams = (midterm + final) / 2

    num_labs =lab_participation(labs)

    if failed_to_participate?(avg_homework, avg_exams, num_labs) do
      0
    else
      mark = calculate_grade(avg_labs, avg_homework, midterm, final)

      calculate_grade(true, mark)
    end
  end
end

""" La méthode avg calcule et retourne la moyenne pour une entrée 
"""

def avg(data) do
    if Enum.count(data) == 0 do
      0
    else
      Enum.sum(data) / Enum.count(data)
    end
  end
end




@doc """ La méthode failed_to_participate? retourne vrai, si la note de l'étudiant n'est pas suffisante pour passer le cours """

def failed_to_participate?(avg_homework, avg_exams, num_labs) do
    avg_homework < 0.4 || avg_exams < 0.4 || num_labs < 3 
  end
end



@doc """ La méthode "calculate_grade" retourne la note de l'étudiant """


def calculate_grade(isNumeric, mark) do
    if isNumeric == true do
      cond do
        mark > 0.895 -> 10
        mark > 0.845 -> 9
        mark > 0.795 -> 8
        mark > 0.745 -> 7
        mark > 0.695 -> 6
        mark > 0.645 -> 5
        mark > 0.595 -> 4
        mark > 0.545 -> 3
        mark > 0.495 -> 2
        mark > 0.395 -> 1
        :else -> 0
      end
    else
      cond do
        mark > 0.895 -> "A+"
        mark > 0.845 -> "A"
        mark > 0.795 -> "A-"
        mark > 0.745 -> "B+"
        mark > 0.695 -> "B"
        mark > 0.645 -> "C+"
        mark > 0.595 -> "C"
        mark > 0.545 -> "D+"
        mark > 0.495 -> "D"
        mark > 0.395 -> "E"
        :else -> "F"
      end
    end
  end


  def calculate_grade(avg_labs, avg_homework, midterm, final) do
    0.2 * avg_labs + 0.3 * avg_homework + 0.2 * midterm + 0.3 * final
  end
end

@doc """ La méthode "lab_participation" retourne le nombre de labs auquels l'étudiant a participé """


  def lab_participation(data) do
    data
      |> Enum.reject(fn mark -> mark < 0.25 end)
      |> Enum.count()
  end
end