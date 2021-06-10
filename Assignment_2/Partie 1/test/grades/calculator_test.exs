defmodule Grades.CalculatorTest do
  use ExUnit.Case
  alias Grades.Calculator

  describe "percentage_grade/1" do
    test "sample" do
      assert 85 ==
               Calculator.percentage_grade(%{
                 homework: [0.8],
                 labs: [1, 1, 1],
                 midterm: 0.70,
                 final: 0.9
               })
    end
  end

  describe "Test1" do
    test "1Percentage" do
      assert 17 == Calculator.percentage_grade(%{homework: [], labs: [], midterm: 0.4, final: 0.3})
    end
    test "1Letter" do
      assert "EIN" == Calculator.letter_grade(%{homework: [], labs: [], midterm: 0.4, final: 0.3})
    end
    test "1Numeric" do
      assert 0 = Calculator.numeric_grade(%{homework: [], labs: [], midterm: 0.4, final: 0.3})
    end
  end

  describe "Test2" do
    test "2Percentage" do
      assert 71 == Calculator.percentage_grade(%{homework: [0.9,1], labs: [0.75,1,1,0.25], midterm: 0.6, final: 0.5})
    end
    test "2Letter" do
      assert "B" == Calculator.letter_grade(%{homework: [0.9,1], labs: [0.75,1,1,0.25], midterm: 0.6, final: 0.5})
    end
    test "2Numeric" do
      assert 6 = Calculator.numeric_grade(%{homework: [0.9,1], labs: [0.75,1,1,0.25], midterm: 0.6, final: 0.5})
    end
  end

  describe "Test3" do
    test "3Percentage" do
      assert 52 == Calculator.percentage_grade(%{homework: [0.3,1,0], labs: [0.75,1,1,0.25,0,1], midterm: 0.6, final: 0.45})
    end
    test "3Letter" do
      assert "D" == Calculator.letter_grade(%{homework: [0.3,1,0], labs: [0.75,1,1,0.25,0,1], midterm: 0.6, final: 0.45})
    end
    test "3Numeric" do
      assert 2 = Calculator.numeric_grade(%{homework: [0.3,1,0], labs: [0.75,1,1,0.25,0,1], midterm: 0.6, final: 0.45})
    end
  end

  describe "Test4" do
    test "4Percentage" do
      assert 100 == Calculator.percentage_grade(%{homework: [1,1,1], labs: [1,1,1,1,1], midterm: 1, final: 1})
    end
    test "4Letter" do
      assert "A+" == Calculator.letter_grade(%{homework: [1,1,1], labs: [1,1,1,1,1], midterm: 1, final: 1})
    end
    test "4Numeric" do
      assert  10 = Calculator.numeric_grade(%{homework: [1,1,1], labs: [1,1,1,1,1], midterm: 1, final: 1})
    end
  end

end
